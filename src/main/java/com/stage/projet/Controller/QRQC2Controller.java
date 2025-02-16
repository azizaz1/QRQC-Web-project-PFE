package com.stage.projet.Controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stage.projet.Model.QRQC;
import com.stage.projet.Model.Stage;
import com.stage.projet.Service.QRQCService;
import com.stage.projet.Service.StageService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class QRQC2Controller {
    
    @Autowired
    private QRQCService qrqcService;
    @Autowired

    private StageService stageService;  // Ensure this is properly injected

    @GetMapping("/qrqcs")
    public List<QRQC> list() {
        System.out.println("Get all QRQCs...");
        return qrqcService.getAll();
    }

    @GetMapping("/qrqcs/{id}")
    public ResponseEntity<QRQC> post(@PathVariable long id) {
        Optional<QRQC> qrqc = qrqcService.findByCode(id);
        return qrqc.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping("/qrqcs")
    public ResponseEntity<Object> save(@RequestBody QRQC qrqc, @RequestParam("stageId") Long stageId) {
        Optional<Stage> stageOptional = stageService.findByCode(stageId);
        if (stageOptional.isPresent()) {
            qrqc.setStage(stageOptional.get());
            qrqcService.save(qrqc);
            // Construct a JSON response object
            Map<String, String> response = new HashMap<>();
            response.put("message", "QRQC added successfully");
            // Return the JSON response with a 200 status code
            return ResponseEntity.ok().body(response);
        } else {
            // Stage not found
            return ResponseEntity.badRequest().body("Stage not found");
        }
    }

   // @PostMapping("/qrqcs")
    //public long save(@RequestBody QRQC qrqc) {
       // return qrqcService.save(qrqc);
    //}

    @PutMapping("/qrqcs/{id}")
    public void update(@PathVariable long id, @RequestBody QRQC qrqc) {
        qrqcService.update(id, qrqc);
    }

    @DeleteMapping("/qrqcs/{id}")
    public void delete(@PathVariable long id) {
        qrqcService.delete(id);
    }
    
    @GetMapping("/search2")
    public List<QRQC> searchQRQC(@RequestParam String NomPrenom) {
        return qrqcService.searchByNomPrenom(NomPrenom);
    }
    @GetMapping("/searchByDateRange")
    public List<QRQC> searchByDateRange(
            @RequestParam("startDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) {
        return qrqcService.searchByDateRange(startDate, endDate);
    }
}
