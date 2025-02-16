package com.stage.projet.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stage.projet.Model.StageQRQC;
@Repository

public interface StageQRQCRepository extends JpaRepository<StageQRQC, Long> {
    //List<StageQRQC> findAllByStatutContaining(String statut);
}
