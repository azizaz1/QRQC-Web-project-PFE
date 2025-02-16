package com.stage.projet.Model;

import java.io.Serializable;
import java.util.Date; // Import Date class
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "StageQRQC")
public class StageQRQC implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateHeure; // Change LocalDateTime to Date
    private String signalePar;
    private String departementLigne;
    private String descriptionProbleme;
    private String gravite;
    private String actionImmediate;
    private String analyseCauseRacine;
    private String actionsCorrectives;
    private String personneResponsable;
    private Date dateLimiteActions; // Change LocalDateTime to Date
    private String verificationActions;
    private String actionsSuivi;
    private String statut;
    private String commentairesNotes;

    // Constructors

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
    }

    public String getSignalePar() {
        return signalePar;
    }

    public void setSignalePar(String signalePar) {
        this.signalePar = signalePar;
    }

    public String getDepartementLigne() {
        return departementLigne;
    }

    public void setDepartementLigne(String departementLigne) {
        this.departementLigne = departementLigne;
    }

    public String getDescriptionProbleme() {
        return descriptionProbleme;
    }

    public void setDescriptionProbleme(String descriptionProbleme) {
        this.descriptionProbleme = descriptionProbleme;
    }

    public String getGravite() {
        return gravite;
    }

    public void setGravite(String gravite) {
        this.gravite = gravite;
    }

    public String getActionImmediate() {
        return actionImmediate;
    }

    public void setActionImmediate(String actionImmediate) {
        this.actionImmediate = actionImmediate;
    }

    public String getAnalyseCauseRacine() {
        return analyseCauseRacine;
    }

    public void setAnalyseCauseRacine(String analyseCauseRacine) {
        this.analyseCauseRacine = analyseCauseRacine;
    }

    public String getActionsCorrectives() {
        return actionsCorrectives;
    }

    public void setActionsCorrectives(String actionsCorrectives) {
        this.actionsCorrectives = actionsCorrectives;
    }

    public String getPersonneResponsable() {
        return personneResponsable;
    }

    public void setPersonneResponsable(String personneResponsable) {
        this.personneResponsable = personneResponsable;
    }

    public Date getDateLimiteActions() {
        return dateLimiteActions;
    }

    public void setDateLimiteActions(Date dateLimiteActions) {
        this.dateLimiteActions = dateLimiteActions;
    }

    public String getVerificationActions() {
        return verificationActions;
    }

    public void setVerificationActions(String verificationActions) {
        this.verificationActions = verificationActions;
    }

    public String getActionsSuivi() {
        return actionsSuivi;
    }

    public void setActionsSuivi(String actionsSuivi) {
        this.actionsSuivi = actionsSuivi;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getCommentairesNotes() {
        return commentairesNotes;
    }

    public void setCommentairesNotes(String commentairesNotes) {
        this.commentairesNotes = commentairesNotes;
    }

    @Override
    public String toString() {
        return "StageQRQC{" +
                "id=" + id +
                ", dateHeure=" + dateHeure +
                ", signalePar='" + signalePar + '\'' +
                ", departementLigne='" + departementLigne + '\'' +
                ", descriptionProbleme='" + descriptionProbleme + '\'' +
                ", gravite='" + gravite + '\'' +
                ", actionImmediate='" + actionImmediate + '\'' +
                ", analyseCauseRacine='" + analyseCauseRacine + '\'' +
                ", actionsCorrectives='" + actionsCorrectives + '\'' +
                ", personneResponsable='" + personneResponsable + '\'' +
                ", dateLimiteActions=" + dateLimiteActions +
                ", verificationActions='" + verificationActions + '\'' +
                ", actionsSuivi='" + actionsSuivi + '\'' +
                ", statut='" + statut + '\'' +
                ", commentairesNotes='" + commentairesNotes + '\'' +
                '}';
    }

    public StageQRQC() {
        super();
    }

    public StageQRQC(Long id, Date dateHeure, String signalePar, String departementLigne, String descriptionProbleme, 
                     String gravite, String actionImmediate, String analyseCauseRacine, String actionsCorrectives, 
                     String personneResponsable, Date dateLimiteActions, String verificationActions, 
                     String actionsSuivi, String statut, String commentairesNotes) {
        super();
        this.id = id;
        this.dateHeure = dateHeure;
        this.signalePar = signalePar;
        this.departementLigne = departementLigne;
        this.descriptionProbleme = descriptionProbleme;
        this.gravite = gravite;
        this.actionImmediate = actionImmediate;
        this.analyseCauseRacine = analyseCauseRacine;
        this.actionsCorrectives = actionsCorrectives;
        this.personneResponsable = personneResponsable;
        this.dateLimiteActions = dateLimiteActions;
        this.verificationActions = verificationActions;
        this.actionsSuivi = actionsSuivi;
        this.statut = statut;
        this.commentairesNotes = commentairesNotes;
    }
}

