package com.stage.projet.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.stage.projet.Model.QRQC;
import com.stage.projet.Model.Stage;
import com.stage.projet.Repository.QRQCRepository;

import org.springframework.data.domain.Sort;

@Service
@jakarta.transaction.Transactional
public class QRQCService {
    @Autowired
    QRQCRepository repository;
    
    public List<QRQC> getAll() {
        System.out.println("GET ALL QRQC...");
        return repository.findAll(Sort.by("id").ascending());           
    }
    
    public Optional<QRQC> findByCode(long id) {
        return repository.findById(id);
    }
    
    public long save(QRQC qrqc) {
        System.out.println("save  all Categories 11111...");
        return repository.save(qrqc).getId();
    }
  
    public void update(long id, QRQC qrqc) {
        Optional<QRQC> qrqcOptional = repository.findById(id);
        if (qrqcOptional.isPresent()) {
            QRQC qrqcToUpdate = qrqcOptional.get();
            qrqcToUpdate.setNomPrenom(qrqc.getNomPrenom());
            qrqcToUpdate.setResponsable(qrqc.getResponsable());
            qrqcToUpdate.setDate(qrqc.getDate());
            qrqcToUpdate.setProduit(qrqc.getProduit());
            qrqcToUpdate.setRef(qrqc.getRef());
            qrqcToUpdate.setTracabilite(qrqc.getTracabilite());
            qrqcToUpdate.setProblemDescription(qrqc.getProblemDescription());
            qrqcToUpdate.setQuantiteisole(qrqc.getQuantiteisole());
            qrqcToUpdate.setNbrPieceDefaut(qrqc.getNbrPieceDefaut());
            qrqcToUpdate.setNiveau(qrqc.getNiveau());
            qrqcToUpdate.setQuoi(qrqc.getQuoi());
            qrqcToUpdate.setQui(qrqc.getQui());
            qrqcToUpdate.setCombien(qrqc.getCombien());
            qrqcToUpdate.setQuand(qrqc.getQuand());
            qrqcToUpdate.setQu(qrqc.getQu());
            qrqcToUpdate.setComment(qrqc.getComment());
            qrqcToUpdate.setPourquoi(qrqc.getPourquoi());
            qrqcToUpdate.setIsolationEmplacement(qrqc.getIsolationEmplacement());
            qrqcToUpdate.setIsolationDetails(qrqc.getIsolationDetails());
            qrqcToUpdate.setIsolationDate(qrqc.getIsolationDate());
            qrqcToUpdate.setIsolationOuiNon(qrqc.isIsolationOuiNon());
            qrqcToUpdate.setRepassageEmplacement(qrqc.getRepassageEmplacement());
            qrqcToUpdate.setRepassageDetails(qrqc.getRepassageDetails());
            qrqcToUpdate.setRepassageDate(qrqc.getRepassageDate());
            qrqcToUpdate.setRepassageOuiNon(qrqc.isRepassageOuiNon());
            qrqcToUpdate.setAlerteProcessEmplacement(qrqc.getAlerteProcessEmplacement());
            qrqcToUpdate.setAlerteProcessDetails(qrqc.getAlerteProcessDetails());
            qrqcToUpdate.setAlerteProcessDate(qrqc.getAlerteProcessDate());
            qrqcToUpdate.setAlerteProcessOuiNon(qrqc.isAlerteProcessOuiNon());
            qrqcToUpdate.setAlerteMaintenanceEmplacement(qrqc.getAlerteMaintenanceEmplacement());
            qrqcToUpdate.setAlerteMaintenanceDetails(qrqc.getAlerteMaintenanceDetails());
            qrqcToUpdate.setAlerteMaintenanceDate(qrqc.getAlerteMaintenanceDate());
            qrqcToUpdate.setAlerteMaintenanceOuiNon(qrqc.isAlerteMaintenanceOuiNon());
            qrqcToUpdate.setAlerteFournisseurEmplacement(qrqc.getAlerteFournisseurEmplacement());
            qrqcToUpdate.setAlerteFournisseurDetails(qrqc.getAlerteFournisseurDetails());
            qrqcToUpdate.setAlerteFournisseurDate(qrqc.getAlerteFournisseurDate());
            qrqcToUpdate.setAlerteFournisseurOuiNon(qrqc.isAlerteFournisseurOuiNon());
            qrqcToUpdate.setChangementLotEmplacement(qrqc.getChangementLotEmplacement());
            qrqcToUpdate.setChangementLotDetails(qrqc.getChangementLotDetails());
            qrqcToUpdate.setChangementLotDate(qrqc.getChangementLotDate());
            qrqcToUpdate.setChangementLotOuiNon(qrqc.isChangementLotOuiNon());
            qrqcToUpdate.setDtcOuvertEmplacement(qrqc.getDtcOuvertEmplacement());
            qrqcToUpdate.setDtcOuvertDetails(qrqc.getDtcOuvertDetails());
            qrqcToUpdate.setDtcOuvertDate(qrqc.getDtcOuvertDate());
            qrqcToUpdate.setDtcOuvertOuiNon(qrqc.isDtcOuvertOuiNon());
            qrqcToUpdate.setTraitementAlerteDetails(qrqc.getTraitementAlerteDetails());
            qrqcToUpdate.setTraitementAlerteDate(qrqc.getTraitementAlerteDate());
            qrqcToUpdate.setTraitementAlerteDetails2(qrqc.getTraitementAlerteDetails2());
            // Set cause de non detection and cause de l'occurrence for P1 to P5
            qrqcToUpdate.setP1CauseNonDetection(qrqc.getP1CauseNonDetection());
            qrqcToUpdate.setP1CauseOccurrence(qrqc.getP1CauseOccurrence());
            qrqcToUpdate.setP2CauseNonDetection(qrqc.getP2CauseNonDetection());
            qrqcToUpdate.setP2CauseOccurrence(qrqc.getP2CauseOccurrence());
            qrqcToUpdate.setP3CauseNonDetection(qrqc.getP3CauseNonDetection());
            qrqcToUpdate.setP3CauseOccurrence(qrqc.getP3CauseOccurrence());
            qrqcToUpdate.setP4CauseNonDetection(qrqc.getP4CauseNonDetection());
            qrqcToUpdate.setP4CauseOccurrence(qrqc.getP4CauseOccurrence());
            qrqcToUpdate.setP5CauseNonDetection(qrqc.getP5CauseNonDetection());
            qrqcToUpdate.setP5CauseOccurrence(qrqc.getP5CauseOccurrence());
            // Set actionCloturee1 to actionCloturee4
            qrqcToUpdate.setActionCloturee1(qrqc.isActionCloturee1());
            qrqcToUpdate.setActionCloturee2(qrqc.isActionCloturee2());
            qrqcToUpdate.setActionCloturee3(qrqc.isActionCloturee3());
            qrqcToUpdate.setActionCloturee4(qrqc.isActionCloturee4());
            // Set corrective1 to corrective4
            qrqcToUpdate.setCorrective1(qrqc.getCorrective1());
            qrqcToUpdate.setCorrective2(qrqc.getCorrective2());
            qrqcToUpdate.setCorrective3(qrqc.getCorrective3());
            qrqcToUpdate.setCorrective4(qrqc.getCorrective4());
            // Set preventive1 to preventive4
            qrqcToUpdate.setPreventive1(qrqc.getPreventive1());
            qrqcToUpdate.setPreventive2(qrqc.getPreventive2());
            qrqcToUpdate.setPreventive3(qrqc.getPreventive3());
            qrqcToUpdate.setPreventive4(qrqc.getPreventive4());
            // Set pilote1 to pilote4
            qrqcToUpdate.setPilote1(qrqc.getPilote1());
            qrqcToUpdate.setPilote2(qrqc.getPilote2());
            qrqcToUpdate.setPilote3(qrqc.getPilote3());
            qrqcToUpdate.setPilote4(qrqc.getPilote4());
            // Set actions1 to actions4
            qrqcToUpdate.setActions1(qrqc.getActions1());
            qrqcToUpdate.setActions2(qrqc.getActions2());
            qrqcToUpdate.setActions3(qrqc.getActions3());
            qrqcToUpdate.setActions4(qrqc.getActions4());

            repository.save(qrqcToUpdate);
        }
    }

    public List<QRQC> findByLibelle(String nom) {
        return repository.findAllByNomPrenomContaining(nom);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
    public List<QRQC> searchByNomPrenom(String NomPrenom) {
        return repository.findByNomPrenomContainingIgnoreCase(NomPrenom);
    }
    public List<QRQC> searchByDateRange(Date startDate, Date endDate) {
        return repository.findByDateBetween(startDate, endDate);
    }
}
