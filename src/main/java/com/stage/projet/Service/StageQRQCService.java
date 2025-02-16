package com.stage.projet.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import com.stage.projet.Model.StageQRQC;
import com.stage.projet.Repository.StageQRQCRepository;

@Service
public class StageQRQCService {

    private final StageQRQCRepository repository;

    @Autowired
    public StageQRQCService(StageQRQCRepository repository) {
        this.repository = repository;
    }

    public List<StageQRQC> getAll() {
        return repository.findAll(Sort.by("dateHeure").descending());
    }

    public Optional<StageQRQC> findById(long id) {
        return repository.findById(id);
    }

    public long save(StageQRQC stageQRQC) {
        return repository.save(stageQRQC).getId();
    }

    public void update(long id, StageQRQC stageQRQC) {
        Optional<StageQRQC> qrqc = repository.findById(id);
        qrqc.ifPresent(q -> {
            q.setDateHeure(stageQRQC.getDateHeure());
            q.setSignalePar(stageQRQC.getSignalePar());
            q.setDepartementLigne(stageQRQC.getDepartementLigne());
            q.setDescriptionProbleme(stageQRQC.getDescriptionProbleme());
            q.setGravite(stageQRQC.getGravite());
            q.setActionImmediate(stageQRQC.getActionImmediate());
            q.setAnalyseCauseRacine(stageQRQC.getAnalyseCauseRacine());
            q.setActionsCorrectives(stageQRQC.getActionsCorrectives());
            q.setPersonneResponsable(stageQRQC.getPersonneResponsable());
            q.setDateLimiteActions(stageQRQC.getDateLimiteActions());
            q.setVerificationActions(stageQRQC.getVerificationActions());
            q.setActionsSuivi(stageQRQC.getActionsSuivi());
            q.setStatut(stageQRQC.getStatut());
            q.setCommentairesNotes(stageQRQC.getCommentairesNotes());
            repository.save(q);
        });
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public List<StageQRQC> findByStatut(String statut) {
        return repository.findAllByStatutContaining(statut);
    }
}
