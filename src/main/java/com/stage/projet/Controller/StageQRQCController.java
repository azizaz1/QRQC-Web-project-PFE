package com.stage.projet.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stage.projet.Model.StageQRQC;
import com.stage.projet.Service.StageQRQCService;

@RestController
@RequestMapping("/api/stageqrqc")
public class StageQRQCController {

    private final StageQRQCService service;

    @Autowired
    public StageQRQCController(StageQRQCService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<StageQRQC>> getAll() {
        List<StageQRQC> qrqcList = service.getAll();
        return new ResponseEntity<>(qrqcList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StageQRQC> getById(@PathVariable long id) {
        Optional<StageQRQC> qrqc = service.findById(id);
        return qrqc.map(stageQRQC -> new ResponseEntity<>(stageQRQC, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody StageQRQC stageQRQC) {
        long id = service.save(stageQRQC);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody StageQRQC stageQRQC) {
        service.update(id, stageQRQC);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/statut/{statut}")
    public ResponseEntity<List<StageQRQC>> getByStatut(@PathVariable String statut) {
        List<StageQRQC> qrqcList = service.findByStatut(statut);
        return new ResponseEntity<>(qrqcList, HttpStatus.OK);
    }
}
