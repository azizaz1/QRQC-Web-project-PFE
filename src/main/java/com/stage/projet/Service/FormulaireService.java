package com.stage.projet.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stage.projet.Model.Formulaire;
import com.stage.projet.Model.User;
import com.stage.projet.Repository.FormulaireRepository;
import com.stage.projet.Repository.UserRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class FormulaireService {

	 @Autowired
		FormulaireRepository repository;
	 
		public List<Formulaire> getAll() {
			System.out.println("Get all Users 11111...");
	    	return repository.findAll(Sort.by("nom_prenom").ascending());	    	
	    }
		
	    public Optional<Formulaire> findById(long id) {
	        return repository.findById(id);
	    }
	    
	    public long save(Formulaire Formulaire) {
	    	System.out.println("save  all Users 11111...");
	    	Formulaire formulaire=new Formulaire();
	    	formulaire.setNom_prenom(Formulaire.getNom_prenom());
	    	formulaire.setMail(Formulaire.getMail());
	    	formulaire.setSpecialité(Formulaire.getSpecialité());
	    	formulaire.setDossier(Formulaire.getDossier());


		 //    User.setPassword(encoder.encode(User.getPassword()));
		        return repository.save(Formulaire).getId();
		                           
	    }

	    public void update( long id, Formulaire Formulaire) {
           Optional<Formulaire>formulairee=repository.findById(id);
    if (formulairee.isPresent()) {
    	Formulaire formulaire =formulairee.get();
    	formulaire.setNom_prenom(Formulaire.getNom_prenom());
    	formulaire.setMail(Formulaire.getMail());
    	formulaire.setSpecialité(Formulaire.getSpecialité());
    	formulaire.setDossier(Formulaire.getDossier());
     repository.save(formulaire);
			}
}
	
	    

	    public void delete(long id) {
	        Optional<Formulaire> formulaire = repository.findById(id);
	        formulaire.ifPresent(repository::delete);
	    }
		
	  
		
		public Optional<Formulaire> login(String nom_prenom) {
			// TODO Auto-generated method stub
			return repository.findByUsername(nom_prenom);
		}

		public Optional<Formulaire> findByTracabilite(String name) {
			// TODO Auto-generated method stub
			return null;
		}

		

}

