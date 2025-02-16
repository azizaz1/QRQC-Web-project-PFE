package com.stage.projet.Controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.stage.projet.Model.Stage;
import com.stage.projet.Model.User;
import com.stage.projet.Service.StageService;
import com.stage.projet.Service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

public class StageController {

    private final StageService stageService;
    private final UserService userService;

    @Autowired
    public StageController(StageService stageService, UserService userService) {
        this.stageService = stageService;
        this.userService = userService;
    }

    @GetMapping("/stages")
    public List<Stage> list() {
        System.out.println("Get all stages...");
        return stageService.getAll();
    }

    @GetMapping("/stages/{id}")
    public ResponseEntity<Stage> post(@PathVariable long id) {
        Optional<Stage> st = stageService.findByCode(id);
        return st.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/stages")
    public ResponseEntity<Object> save(@RequestBody Stage stage, @RequestParam("userId") Long userId) {
        Optional<User> userOptional = userService.findById(userId);
        if (userOptional.isPresent()) {
            stage.setUser(userOptional.get());
            stageService.save(stage);
            // Construct a JSON response object
            Map<String, String> response = new HashMap<>();
            response.put("message", "Stage added successfully");
            // Return the JSON response with a 200 status code
            return ResponseEntity.ok().body(response);
        } else {
            // User not found
            return ResponseEntity.badRequest().body("User not found");
        }
    }







    @PutMapping("/stages/{id}")
    public void update(@PathVariable long id, @RequestBody Stage stage) {
        stageService.update(id, stage);
    }

    @DeleteMapping("/stages/{id}")
    public void delete(@PathVariable long id) {
        stageService.delete(id);
    }

    @GetMapping("/search")
    public List<Stage> searchStages(@RequestParam String description) {
        return stageService.searchByDescription(description);
    }

    @GetMapping("/searchByDateIncident")
    public List<Stage> searchStagesByDateIncident(@RequestParam Date date) {
        return stageService.searchByDateIncident(date);
    }

}
