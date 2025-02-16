package com.stage.projet.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import com.stage.projet.Model.Stage;
import com.stage.projet.Repository.StageRepository;

@Service
public class StageService {

    private final StageRepository repository;

    @Autowired
    public StageService(StageRepository repository) {
        this.repository = repository;
    }

    public List<Stage> getAll() {
        return repository.findAll(Sort.by("id").ascending());
    }

    public Optional<Stage> findByCode(long id) {
        return repository.findById(id);
    }

    public long save(Stage stage) {
        return repository.save(stage).getId();
    }

    public void update(long id, Stage stage) {
        Optional<Stage> stagy = repository.findById(id);
        stagy.ifPresent(st -> {
            st.setNom_entreprise(stage.getNom_entreprise());
            st.setTitreStage(stage.getTitreStage());
            st.setDescription(stage.getDescription());
            st.setDateIncident(stage.getDateIncident());
            st.setLieuIncident(stage.getLieuIncident());
            st.setEquipementComposant(stage.getEquipementComposant());
            st.setDommagesMateriels(stage.getDommagesMateriels());
            st.setGraviteIncident(stage.getGraviteIncident());
            st.setFacteursContributifs(stage.getFacteursContributifs());
            st.setActionCorrective(stage.getActionCorrective());
            st.setImageRapport(stage.getImageRapport()); // Update imageRapport attribute
            repository.save(st);
        });
    }


    public List<Stage> findByLibelle(String Nom_entreprise) {
        return repository.findAllByTitreStageContaining(Nom_entreprise);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public List<Stage> searchByDateIncident(final Date date) {
        return repository.findByDateIncident(date);
    }
}
