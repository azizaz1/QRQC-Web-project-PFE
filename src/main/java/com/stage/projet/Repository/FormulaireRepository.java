package com.stage.projet.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stage.projet.Model.Formulaire;
import com.stage.projet.Model.User;
@Repository
public interface FormulaireRepository extends JpaRepository<Formulaire, Long> {

	//Optional<Formulaire> findByUsername(String nom_prenom);


	//Optional<Formulaire> findByUsername(String nom_prenom);

	//Optional<Formulaire> findById(long id);



	//List<Formulaire> findAll(Sort ascending);

}
