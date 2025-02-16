package com.stage.projet.Service;

import java.time.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stage.projet.Model.User;
import com.stage.projet.Repository.UserRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class UserService {
	 
	
	 @Autowired
		UserRepository repository;
	 
		public List<User> getAll() {
			System.out.println("Get all Users 11111...");
	    	return repository.findAll(Sort.by("username").ascending());	    	
	    }
		
	    public Optional<User> findById(long id) {
	        return repository.findById(id);
	    }
	    
	    public long save(User User) {
	    	System.out.println("save  all Users 11111...");
               User user=new User();
               user.setUsername(User.getUsername());
               user.setEmail(User.getEmail());
               user.setPassword(User.getPassword());
               user.setRole(User.getRole());
               user.setActive(User.isActive());


		 //    User.setPassword(encoder.encode(User.getPassword()));
		        return repository.save(User).getId();
		                           
	    }

	    public void update(long id, User updatedUser) {
	        Optional<User> optionalUser = repository.findById(id);
	        if (optionalUser.isPresent()) {
	            User user = optionalUser.get();
	            user.setUsername(updatedUser.getUsername());
	            user.setEmail(updatedUser.getEmail());
	            user.setRole(updatedUser.getRole());
	            user.setActive(updatedUser.isActive());
	            // Check if the updated password is not null or empty
	            if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
	                user.setPassword(updatedUser.getPassword());
	            }
	            repository.save(user);
	        } else {
	            // Handle user not found
	        }
	    }
	
	    

	    public void delete(long id) {
	        Optional<User> user = repository.findById(id);
	        user.ifPresent(repository::delete);
	    }
		
	  
		
	    public Optional<User> login(String username, String password) {
	        return repository.findByUsernameAndPassword(username, password);
	    }
		public User getCurrentUser() {
			// TODO Auto-generated method stub
			return null;
		}

		
		

		    

}
