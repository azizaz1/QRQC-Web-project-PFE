package com.stage.projet.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stage.projet.Model.QRQC;
import com.stage.projet.Model.Stage;
@Repository
public interface QRQCRepository extends JpaRepository<QRQC, Long>{

	//List<QRQC> findByDateBetween(Date startDate, Date endDate);

	//List<Emploi> findAll(Sort ascending);
    //List<QRQC> findByNomPrenomContaining(String NomPrenom);

	//List<Emploi> findAllByTitreStageContaining(String entreprise_nom);

	//void save(Emploi st);

	//Optional<Emploi> findById(long id);


}
