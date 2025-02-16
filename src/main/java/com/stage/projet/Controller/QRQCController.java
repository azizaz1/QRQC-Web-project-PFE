package com.stage.projet.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stage.projet.Model.Formulaire;
import com.stage.projet.Model.User;
import com.stage.projet.Service.FormulaireService;
import com.stage.projet.Service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class QRQCController {
	
	@Autowired private FormulaireService formulaireService;
	 
	 
	 
	 @GetMapping("/forms")
	    public List<Formulaire> list() {
		 System.out.println("Get all Users...");
	             return formulaireService.getAll();
	   }
	 	 
	 @GetMapping("/forms/{id}")
	 public ResponseEntity<Formulaire> post(@PathVariable long id) {
	        Optional<Formulaire> cat = formulaireService.findById(id);
	        
	        return cat.map(ResponseEntity::ok)
	        		
	                   .orElseGet(() -> ResponseEntity.notFound()
                                               .build());
	    }

	 
	 @GetMapping("/forms/auth/{name}")
	 public ResponseEntity<Formulaire> login(@PathVariable String name) {
	        Optional<Formulaire> cat = formulaireService.login(name);
	        return cat.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());}
	 
	 @GetMapping("/forms/7/{name}")
	 public ResponseEntity<Formulaire> post(@PathVariable String name) {
	        Optional<Formulaire> cat = formulaireService.login(name);
	        return cat.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());}
	
	    
	 @PostMapping("/forms")
	 public long save(@RequestBody Formulaire Formulaire){
	    return formulaireService.save(Formulaire);
	 }
	 
	   

	 @PutMapping("/forms/{id}")
	    public void update(@PathVariable long id,@RequestBody Formulaire Formulaire) {
				
	      Optional<Formulaire> cat=formulaireService.findById(id);
	 if (cat.isPresent()) {
		 formulaireService.update(id,Formulaire);
	    }
	 else {
		 formulaireService.save(Formulaire);
	 }      }

	    @DeleteMapping("/forms/{id}")
	    public void delete(@PathVariable long id) {
	    	formulaireService.delete(id);
	    }
}
	    
	    