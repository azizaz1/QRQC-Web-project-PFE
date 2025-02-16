package com.stage.projet.Controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import java.nio.file.Files;
import java.nio.file.Paths;

import jakarta.servlet.ServletContext;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import org.springframework.web.multipart.MultipartFile;
import com.stage.projet.Model.User;
import com.stage.projet.Service.UserService;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired private UserService userService;
	 
	 
	 
	 @GetMapping("/users")
	    public List<User> list() {
		 System.out.println("Get all Users...");
	             return userService.getAll();
	   }
	 	 
	 @GetMapping("/users/{id}")
	 public ResponseEntity<User> post(@PathVariable long id) {
	        Optional<User> cat = userService.findById(id);
	        
	        return cat.map(ResponseEntity::ok)
	        		
	                   .orElseGet(() -> ResponseEntity.notFound()
                                               .build());
	    }

	 
	 @GetMapping("/users/auth/{username}")
	 public ResponseEntity<User> login(@PathVariable String username, @RequestParam String password) {
	     Optional<User> userOptional = userService.login(username, password);
	     
	     return userOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	 }
	 
	 @GetMapping("/users/7/{name}")
	 public ResponseEntity<User> post(@PathVariable String name) {
	        Optional<User> cat = userService.login(name);
	        return cat.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());}
	
	    
	 @PostMapping("/users")
	 public long save(@RequestBody User User){
	    return userService.save(User);
	 }
	 
	   

	 @PutMapping("/users/{id}")
	    public void update(@PathVariable long id,@RequestBody User User) {
				
	      Optional<User> cat=userService.findById(id);
	 if (cat.isPresent()) {
		 userService.update(id,User);
	    }
	 else {
		 userService.save(User);
	 }      }

	    @DeleteMapping("/Users/{id}")
	    public void delete(@PathVariable long id) {
	        userService.delete(id);
	    }
	    @PutMapping("/users/{id}/change-password")
	    public ResponseEntity<String> changePassword(@PathVariable long id, @RequestBody Map<String, String> passwordMap) {
	        System.out.println("Received ID: " + id);
	        String newPassword = passwordMap.get("newPassword");
	        String currentPassword = passwordMap.get("currentPassword");

	        // Check if the received ID matches the logged-in user's ID or perform additional validation if necessary

	        Optional<User> optionalUser = userService.findById(id);
	        if (optionalUser.isPresent()) {
	            User user = optionalUser.get();
	            // Check if the current password matches the user's password in the database
	            if (user.getPassword().equals(currentPassword)) {
	                // Update the user's password with the new password
	                user.setPassword(newPassword);
	                userService.update(id, user);
	                return ResponseEntity.ok("Password updated successfully.");
	            } else {
	                return ResponseEntity.badRequest().body("Current password is incorrect.");
	            }
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }


	    
}
	    
	    