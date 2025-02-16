package com.stage.projet.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import com.stage.projet.Model.Stage;
@Repository


public interface StageRepository extends JpaRepository<Stage, Long>{


	//List<Stage> findByDescription(String description);

	List<Stage> findByDescriptionContaining(String description);

	

    //List<Stage> findByDateIncident(Date dateIncident);
	





	//List<Stage> findAllByeStageContaining(String nom_entreprise);

	//List<Stage> findAllByTitreStageContaining(String nom_entreprise);

	

	//Optional<Stage> findByTitre(long id);

	//List<Stage> findAllByTitreStageContaining(String Nom_entreprise);
	
	

} 
