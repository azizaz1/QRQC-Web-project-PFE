package com.stage.projet.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "QRQC")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class QRQC {
    private static final long serialVersionUID = 1L;

    public enum Etat {
        ACTIVE,
        CLOTUREE
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NomPrenom")

    private String NomPrenom;
    private String Responsable;
    private Date Date;
    private String Produit;
    private String Ref;
    private String tracabilite;
    private String  ProblemDescription;
    private int quantiteisole;
    private int nbrPieceDefaut;
    private String Niveau;
  
 // New attributes with String type
    private String Quoi;
    private String Qui;
    private String Combien;
    private String Quand;
    private String Qu;
    private String Comment;
    private String Pourquoi;
    //
    private String isolationEmplacement; // String
    private String isolationDetails;     // String
    private Date isolationDate;          // Date
    private boolean isolationOuiNon = false;    // Checkbox (boolean)
    //reppassage
    private String repassageEmplacement; // String
    private String repassageDetails;     // String
    private Date repassageDate;          // Date
    private boolean repassageOuiNon = false; 
    //process
    private String alerteProcessEmplacement; // String
    private String alerteProcessDetails;     // String
    private Date alerteProcessDate;          // Date
    private boolean alerteProcessOuiNon = false;     // Checkbox (boolean)
    //maintenance

    private String alerteMaintenanceEmplacement; // String
    private String alerteMaintenanceDetails;     // String
    private Date alerteMaintenanceDate;          // Date
    private boolean alerteMaintenanceOuiNon = false;     // Checkbox (boolean)
    //fournisseur 
    
    private String alerteFournisseurEmplacement; // String
    private String alerteFournisseurDetails;     // String
    private Date alerteFournisseurDate;          // Date
    private boolean alerteFournisseurOuiNon= false;     // Checkbox (boolean)
    //
    private String changementLotEmplacement; // String
    private String changementLotDetails;     // String
    private Date changementLotDate;          // Date
    private boolean changementLotOuiNon= false;     // Checkbox (boolean)
    
    private String dtcOuvertEmplacement; // String
    private String dtcOuvertDetails;     // String
    private Date dtcOuvertDate;          // Date
    private boolean dtcOuvertOuiNon= false;     // Checkbox (boolean)
    
    private String traitementAlerteDetails;
    private Date traitementAlerteDate; // Date type
    private String traitementAlerteDetails2;
    
/////D4
    private String p1CauseNonDetection;

    private String p1CauseOccurrence;

    // Cause de non detection and Cause de l'occurence for P2
    private String p2CauseNonDetection;

    private String p2CauseOccurrence;

    // Cause de non detection and Cause de l'occurence for P3
    private String p3CauseNonDetection;

    private String p3CauseOccurrence;

    // Cause de non detection and Cause de l'occurence for P4
    private String p4CauseNonDetection;

    private String p4CauseOccurrence;

    // Cause de non detection and Cause de l'occurence for P5
    private String p5CauseNonDetection;

    private String p5CauseOccurrence;

    private String actions1;
    private String actions2;
    private String actions3;
    private String actions4;
    
    private String corrective1;
    private String corrective2;
    private String corrective3;
    private String corrective4;
    
    private String preventive1;
    private String preventive2;
    private String preventive3;
    private String preventive4;
    
    // Changing actionCloturee1 to a boolean type
    private boolean actionCloturee1= false;
    private boolean actionCloturee2= false;
    private boolean actionCloturee3= false;
    private boolean actionCloturee4= false;
    
    private String pilote1;
    private String pilote2;
    private String pilote3;
    private String pilote4;
    
    // New attributes with int type
    private int quantiteProduitAvant;
    private int quantiteDefectueuseAvant;
    private int quantiteProduitApres;
    private int quantiteDefectueuseApres;
    private String cloturisationPourcentage;
    // New attribute with checkbox
    private boolean qrqcNonCloture = false;
    private boolean qrqcNonEscalade = false;
    
   
    //@OneToMany(mappedBy = "qrqc", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    //private List<Formulaire> formulaire1 = new ArrayList<>();
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stage_id")
    private Stage stage;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomPrenom() {
        return NomPrenom;
    }

    public void setNomPrenom(String nomPrenom) {
        NomPrenom = nomPrenom;
    }

    public String getResponsable() {
        return Responsable;
    }

    public void setResponsable(String responsable) {
        Responsable = responsable;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        Date = date;
    }

    public String getProduit() {
        return Produit;
    }

    public void setProduit(String produit) {
        Produit = produit;
    }

    public String getRef() {
        return Ref;
    }

    public void setRef(String ref) {
        Ref = ref;
    }

    public String getTracabilite() {
        return tracabilite;
    }

    public void setTracabilite(String tracabilite) {
        this.tracabilite = tracabilite;
    }

    public String getProblemDescription() {
        return ProblemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        ProblemDescription = problemDescription;
    }

    public int getQuantiteisole() {
        return quantiteisole;
    }

    public void setQuantiteisole(int quantiteisole) {
        this.quantiteisole = quantiteisole;
    }

    public int getNbrPieceDefaut() {
        return nbrPieceDefaut;
    }

    public void setNbrPieceDefaut(int nbrPieceDefaut) {
        this.nbrPieceDefaut = nbrPieceDefaut;
    }

    public String getNiveau() {
        return Niveau;
    }

    public void setNiveau(String niveau) {
        Niveau = niveau;
    }
   

   //public List<Formulaire> getFormulaire1() {
       // return formulaire1;
    //}

    //public void setFormulaire1(List<Formulaire> formulaire1) {
       // this.formulaire1 = formulaire1;
    //}

    public String getQuoi() {
		return Quoi;
	}

	public void setQuoi(String quoi) {
		Quoi = quoi;
	}

	public String getQui() {
		return Qui;
	}

	public void setQui(String qui) {
		Qui = qui;
	}

	public String getCombien() {
		return Combien;
	}

	public void setCombien(String combien) {
		Combien = combien;
	}

	public String getQuand() {
		return Quand;
	}

	public void setQuand(String quand) {
		Quand = quand;
	}

	public String getQu() {
		return Qu;
	}

	public void setQu(String qu) {
		Qu = qu;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	public String getPourquoi() {
		return Pourquoi;
	}

	public void setPourquoi(String pourquoi) {
		Pourquoi = pourquoi;
	}
	///////
	///////
	///////

	public String getIsolationEmplacement() {
		return isolationEmplacement;
	}

	public void setIsolationEmplacement(String isolationEmplacement) {
		this.isolationEmplacement = isolationEmplacement;
	}

	public String getIsolationDetails() {
		return isolationDetails;
	}

	public void setIsolationDetails(String isolationDetails) {
		this.isolationDetails = isolationDetails;
	}

	public Date getIsolationDate() {
		return isolationDate;
	}

	public void setIsolationDate(Date isolationDate) {
		this.isolationDate = isolationDate;
	}

	public boolean isIsolationOuiNon() {
		return isolationOuiNon;
	}

	public void setIsolationOuiNon(boolean isolationOuiNon) {
		this.isolationOuiNon = isolationOuiNon;
	}

	public String getRepassageEmplacement() {
		return repassageEmplacement;
	}

	public void setRepassageEmplacement(String repassageEmplacement) {
		this.repassageEmplacement = repassageEmplacement;
	}

	public String getRepassageDetails() {
		return repassageDetails;
	}

	public void setRepassageDetails(String repassageDetails) {
		this.repassageDetails = repassageDetails;
	}

	public Date getRepassageDate() {
		return repassageDate;
	}

	public void setRepassageDate(Date repassageDate) {
		this.repassageDate = repassageDate;
	}

	public boolean isRepassageOuiNon() {
		return repassageOuiNon;
	}

	public void setRepassageOuiNon(boolean repassageOuiNon) {
		this.repassageOuiNon = repassageOuiNon;
	}

	public String getAlerteProcessEmplacement() {
		return alerteProcessEmplacement;
	}

	public void setAlerteProcessEmplacement(String alerteProcessEmplacement) {
		this.alerteProcessEmplacement = alerteProcessEmplacement;
	}

	public String getAlerteProcessDetails() {
		return alerteProcessDetails;
	}

	public void setAlerteProcessDetails(String alerteProcessDetails) {
		this.alerteProcessDetails = alerteProcessDetails;
	}

	public Date getAlerteProcessDate() {
		return alerteProcessDate;
	}

	public void setAlerteProcessDate(Date alerteProcessDate) {
		this.alerteProcessDate = alerteProcessDate;
	}

	public boolean isAlerteProcessOuiNon() {
		return alerteProcessOuiNon;
	}

	public void setAlerteProcessOuiNon(boolean alerteProcessOuiNon) {
		this.alerteProcessOuiNon = alerteProcessOuiNon;
	}

	public String getAlerteMaintenanceEmplacement() {
		return alerteMaintenanceEmplacement;
	}

	public void setAlerteMaintenanceEmplacement(String alerteMaintenanceEmplacement) {
		this.alerteMaintenanceEmplacement = alerteMaintenanceEmplacement;
	}

	public String getAlerteMaintenanceDetails() {
		return alerteMaintenanceDetails;
	}

	public void setAlerteMaintenanceDetails(String alerteMaintenanceDetails) {
		this.alerteMaintenanceDetails = alerteMaintenanceDetails;
	}

	public Date getAlerteMaintenanceDate() {
		return alerteMaintenanceDate;
	}

	public void setAlerteMaintenanceDate(Date alerteMaintenanceDate) {
		this.alerteMaintenanceDate = alerteMaintenanceDate;
	}

	public boolean isAlerteMaintenanceOuiNon() {
		return alerteMaintenanceOuiNon;
	}

	public void setAlerteMaintenanceOuiNon(boolean alerteMaintenanceOuiNon) {
		this.alerteMaintenanceOuiNon = alerteMaintenanceOuiNon;
	}

	public String getAlerteFournisseurEmplacement() {
		return alerteFournisseurEmplacement;
	}

	public void setAlerteFournisseurEmplacement(String alerteFournisseurEmplacement) {
		this.alerteFournisseurEmplacement = alerteFournisseurEmplacement;
	}

	public String getAlerteFournisseurDetails() {
		return alerteFournisseurDetails;
	}

	public void setAlerteFournisseurDetails(String alerteFournisseurDetails) {
		this.alerteFournisseurDetails = alerteFournisseurDetails;
	}

	public Date getAlerteFournisseurDate() {
		return alerteFournisseurDate;
	}

	public void setAlerteFournisseurDate(Date alerteFournisseurDate) {
		this.alerteFournisseurDate = alerteFournisseurDate;
	}

	public boolean isAlerteFournisseurOuiNon() {
		return alerteFournisseurOuiNon;
	}

	public void setAlerteFournisseurOuiNon(boolean alerteFournisseurOuiNon) {
		this.alerteFournisseurOuiNon = alerteFournisseurOuiNon;
	}

	public String getChangementLotEmplacement() {
		return changementLotEmplacement;
	}

	public void setChangementLotEmplacement(String changementLotEmplacement) {
		this.changementLotEmplacement = changementLotEmplacement;
	}

	public String getChangementLotDetails() {
		return changementLotDetails;
	}

	public void setChangementLotDetails(String changementLotDetails) {
		this.changementLotDetails = changementLotDetails;
	}

	public Date getChangementLotDate() {
		return changementLotDate;
	}

	public void setChangementLotDate(Date changementLotDate) {
		this.changementLotDate = changementLotDate;
	}

	public boolean isChangementLotOuiNon() {
		return changementLotOuiNon;
	}

	public void setChangementLotOuiNon(boolean changementLotOuiNon) {
		this.changementLotOuiNon = changementLotOuiNon;
	}

	public String getDtcOuvertEmplacement() {
		return dtcOuvertEmplacement;
	}

	public void setDtcOuvertEmplacement(String dtcOuvertEmplacement) {
		this.dtcOuvertEmplacement = dtcOuvertEmplacement;
	}

	public String getDtcOuvertDetails() {
		return dtcOuvertDetails;
	}

	public void setDtcOuvertDetails(String dtcOuvertDetails) {
		this.dtcOuvertDetails = dtcOuvertDetails;
	}

	public Date getDtcOuvertDate() {
		return dtcOuvertDate;
	}

	public void setDtcOuvertDate(Date dtcOuvertDate) {
		this.dtcOuvertDate = dtcOuvertDate;
	}

	public boolean isDtcOuvertOuiNon() {
		return dtcOuvertOuiNon;
	}

	public void setDtcOuvertOuiNon(boolean dtcOuvertOuiNon) {
		this.dtcOuvertOuiNon = dtcOuvertOuiNon;
	}

	public String getTraitementAlerteDetails() {
		return traitementAlerteDetails;
	}

	public void setTraitementAlerteDetails(String traitementAlerteDetails) {
		this.traitementAlerteDetails = traitementAlerteDetails;
	}

	public Date getTraitementAlerteDate() {
		return traitementAlerteDate;
	}

	public void setTraitementAlerteDate(Date traitementAlerteDate) {
		this.traitementAlerteDate = traitementAlerteDate;
	}

	public String getTraitementAlerteDetails2() {
		return traitementAlerteDetails2;
	}

	public void setTraitementAlerteDetails2(String traitementAlerteDetails2) {
		this.traitementAlerteDetails2 = traitementAlerteDetails2;
	}
	
	

	

	public String getP1CauseNonDetection() {
		return p1CauseNonDetection;
	}

	public void setP1CauseNonDetection(String p1CauseNonDetection) {
		this.p1CauseNonDetection = p1CauseNonDetection;
	}

	public String getP1CauseOccurrence() {
		return p1CauseOccurrence;
	}

	public void setP1CauseOccurrence(String p1CauseOccurrence) {
		this.p1CauseOccurrence = p1CauseOccurrence;
	}

	public String getP2CauseNonDetection() {
		return p2CauseNonDetection;
	}

	public void setP2CauseNonDetection(String p2CauseNonDetection) {
		this.p2CauseNonDetection = p2CauseNonDetection;
	}

	public String getP2CauseOccurrence() {
		return p2CauseOccurrence;
	}

	public void setP2CauseOccurrence(String p2CauseOccurrence) {
		this.p2CauseOccurrence = p2CauseOccurrence;
	}

	public String getP3CauseNonDetection() {
		return p3CauseNonDetection;
	}

	public void setP3CauseNonDetection(String p3CauseNonDetection) {
		this.p3CauseNonDetection = p3CauseNonDetection;
	}

	public String getP3CauseOccurrence() {
		return p3CauseOccurrence;
	}

	public void setP3CauseOccurrence(String p3CauseOccurrence) {
		this.p3CauseOccurrence = p3CauseOccurrence;
	}

	public String getP4CauseNonDetection() {
		return p4CauseNonDetection;
	}

	public void setP4CauseNonDetection(String p4CauseNonDetection) {
		this.p4CauseNonDetection = p4CauseNonDetection;
	}

	public String getP4CauseOccurrence() {
		return p4CauseOccurrence;
	}

	public void setP4CauseOccurrence(String p4CauseOccurrence) {
		this.p4CauseOccurrence = p4CauseOccurrence;
	}

	public String getP5CauseNonDetection() {
		return p5CauseNonDetection;
	}

	public void setP5CauseNonDetection(String p5CauseNonDetection) {
		this.p5CauseNonDetection = p5CauseNonDetection;
	}

	public String getP5CauseOccurrence() {
		return p5CauseOccurrence;
	}

	public void setP5CauseOccurrence(String p5CauseOccurrence) {
		this.p5CauseOccurrence = p5CauseOccurrence;
	}
	

	public String getActions1() {
		return actions1;
	}

	public void setActions1(String actions1) {
		this.actions1 = actions1;
	}

	public String getActions2() {
		return actions2;
	}

	public void setActions2(String actions2) {
		this.actions2 = actions2;
	}

	public String getActions3() {
		return actions3;
	}

	public void setActions3(String actions3) {
		this.actions3 = actions3;
	}

	public String getActions4() {
		return actions4;
	}

	public void setActions4(String actions4) {
		this.actions4 = actions4;
	}

	public String getCorrective1() {
		return corrective1;
	}

	public void setCorrective1(String corrective1) {
		this.corrective1 = corrective1;
	}

	public String getCorrective2() {
		return corrective2;
	}

	public void setCorrective2(String corrective2) {
		this.corrective2 = corrective2;
	}

	public String getCorrective3() {
		return corrective3;
	}

	public void setCorrective3(String corrective3) {
		this.corrective3 = corrective3;
	}

	public String getCorrective4() {
		return corrective4;
	}

	public void setCorrective4(String corrective4) {
		this.corrective4 = corrective4;
	}

	public String getPreventive1() {
		return preventive1;
	}

	public void setPreventive1(String preventive1) {
		this.preventive1 = preventive1;
	}

	public String getPreventive2() {
		return preventive2;
	}

	public void setPreventive2(String preventive2) {
		this.preventive2 = preventive2;
	}

	public String getPreventive3() {
		return preventive3;
	}

	public void setPreventive3(String preventive3) {
		this.preventive3 = preventive3;
	}

	public String getPreventive4() {
		return preventive4;
	}

	public void setPreventive4(String preventive4) {
		this.preventive4 = preventive4;
	}

	public boolean isActionCloturee1() {
		return actionCloturee1;
	}

	public void setActionCloturee1(boolean actionCloturee1) {
		this.actionCloturee1 = actionCloturee1;
	}

	public boolean isActionCloturee2() {
		return actionCloturee2;
	}

	public void setActionCloturee2(boolean actionCloturee2) {
		this.actionCloturee2 = actionCloturee2;
	}

	public boolean isActionCloturee3() {
		return actionCloturee3;
	}

	public void setActionCloturee3(boolean actionCloturee3) {
		this.actionCloturee3 = actionCloturee3;
	}

	public boolean isActionCloturee4() {
		return actionCloturee4;
	}

	public void setActionCloturee4(boolean actionCloturee4) {
		this.actionCloturee4 = actionCloturee4;
	}

	public String getPilote1() {
		return pilote1;
	}

	public void setPilote1(String pilote1) {
		this.pilote1 = pilote1;
	}

	public String getPilote2() {
		return pilote2;
	}

	public void setPilote2(String pilote2) {
		this.pilote2 = pilote2;
	}

	public String getPilote3() {
		return pilote3;
	}

	public void setPilote3(String pilote3) {
		this.pilote3 = pilote3;
	}

	public String getPilote4() {
		return pilote4;
	}

	public void setPilote4(String pilote4) {
		this.pilote4 = pilote4;
	}
	

	public int getQuantiteProduitAvant() {
		return quantiteProduitAvant;
	}

	public void setQuantiteProduitAvant(int quantiteProduitAvant) {
		this.quantiteProduitAvant = quantiteProduitAvant;
	}

	public int getQuantiteDefectueuseAvant() {
		return quantiteDefectueuseAvant;
	}

	public void setQuantiteDefectueuseAvant(int quantiteDefectueuseAvant) {
		this.quantiteDefectueuseAvant = quantiteDefectueuseAvant;
	}

	public int getQuantiteProduitApres() {
		return quantiteProduitApres;
	}

	public void setQuantiteProduitApres(int quantiteProduitApres) {
		this.quantiteProduitApres = quantiteProduitApres;
	}

	public int getQuantiteDefectueuseApres() {
		return quantiteDefectueuseApres;
	}

	public void setQuantiteDefectueuseApres(int quantiteDefectueuseApres) {
		this.quantiteDefectueuseApres = quantiteDefectueuseApres;
	}

	public String getCloturisationPourcentage() {
		return cloturisationPourcentage;
	}

	public void setCloturisationPourcentage(String cloturisationPourcentage) {
		this.cloturisationPourcentage = cloturisationPourcentage;
	}

	public boolean isQrqcNonCloture() {
		return qrqcNonCloture;
	}

	public void setQrqcNonCloture(boolean qrqcNonCloture) {
		this.qrqcNonCloture = qrqcNonCloture;
	}

	public boolean isQrqcNonEscalade() {
		return qrqcNonEscalade;
	}

	public void setQrqcNonEscalade(boolean qrqcNonEscalade) {
		this.qrqcNonEscalade = qrqcNonEscalade;
	}
	

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	

	public static long getSerialVersionUID() {
        return serialVersionUID;
    }
	

	@Override
	public String toString() {
	    return "QRQC [id=" + id + ", NomPrenom=" + NomPrenom + ", Responsable=" + Responsable + ", Date=" + Date
	            + ", Produit=" + Produit + ", Ref=" + Ref + ", tracabilite=" + tracabilite + ", ProblemDescription="
	            + ProblemDescription + ", quantiteisole=" + quantiteisole + ", nbrPieceDefaut=" + nbrPieceDefaut
	            + ", Niveau=" + Niveau + ", Quoi=" + Quoi + ", Qui=" + Qui + ", Combien=" + Combien + ", Quand=" + Quand
	            + ", Qu=" + Qu + ", Comment=" + Comment + ", Pourquoi=" + Pourquoi + ", isolationEmplacement="
	            + isolationEmplacement + ", isolationDetails=" + isolationDetails + ", isolationDate=" + isolationDate
	            + ", isolationOuiNon=" + isolationOuiNon + ", repassageEmplacement=" + repassageEmplacement
	            + ", repassageDetails=" + repassageDetails + ", repassageDate=" + repassageDate + ", repassageOuiNon="
	            + repassageOuiNon + ", alerteProcessEmplacement=" + alerteProcessEmplacement + ", alerteProcessDetails="
	            + alerteProcessDetails + ", alerteProcessDate=" + alerteProcessDate + ", alerteProcessOuiNon="
	            + alerteProcessOuiNon + ", alerteMaintenanceEmplacement=" + alerteMaintenanceEmplacement
	            + ", alerteMaintenanceDetails=" + alerteMaintenanceDetails + ", alerteMaintenanceDate="
	            + alerteMaintenanceDate + ", alerteMaintenanceOuiNon=" + alerteMaintenanceOuiNon
	            + ", alerteFournisseurEmplacement=" + alerteFournisseurEmplacement + ", alerteFournisseurDetails="
	            + alerteFournisseurDetails + ", alerteFournisseurDate=" + alerteFournisseurDate
	            + ", alerteFournisseurOuiNon=" + alerteFournisseurOuiNon + ", changementLotEmplacement="
	            + changementLotEmplacement + ", changementLotDetails=" + changementLotDetails + ", changementLotDate="
	            + changementLotDate + ", changementLotOuiNon=" + changementLotOuiNon + ", dtcOuvertEmplacement="
	            + dtcOuvertEmplacement + ", dtcOuvertDetails=" + dtcOuvertDetails + ", dtcOuvertDate=" + dtcOuvertDate
	            + ", dtcOuvertOuiNon=" + dtcOuvertOuiNon + ", traitementAlerteDetails=" + traitementAlerteDetails
	            + ", traitementAlerteDate=" + traitementAlerteDate + ", traitementAlerteDetails2="
	            + traitementAlerteDetails2 
	            // Adding P1 to P5 cause de non detection and cause de l'occurrence
	            + ", p1CauseNonDetection=" + p1CauseNonDetection + ", p1CauseOccurrence=" + p1CauseOccurrence
	            + ", p2CauseNonDetection=" + p2CauseNonDetection + ", p2CauseOccurrence=" + p2CauseOccurrence
	            + ", p3CauseNonDetection=" + p3CauseNonDetection + ", p3CauseOccurrence=" + p3CauseOccurrence
	            + ", p4CauseNonDetection=" + p4CauseNonDetection + ", p4CauseOccurrence=" + p4CauseOccurrence
	            + ", p5CauseNonDetection=" + p5CauseNonDetection + ", p5CauseOccurrence=" + p5CauseOccurrence 
	            // Adding actionCloturee1 to actionCloturee4
	            + ", actionCloturee1=" + actionCloturee1 + ", actionCloturee2=" + actionCloturee2
	            + ", actionCloturee3=" + actionCloturee3 + ", actionCloturee4=" + actionCloturee4 
	            // Adding corrective1 to corrective4
	            + ", corrective1=" + corrective1 + ", corrective2=" + corrective2
	            + ", corrective3=" + corrective3 + ", corrective4=" + corrective4 
	            // Adding preventive1 to preventive4
	            + ", preventive1=" + preventive1 + ", preventive2=" + preventive2
	            + ", preventive3=" + preventive3 + ", preventive4=" + preventive4 
	            // Adding pilote1 to pilote4
	            + ", pilote1=" + pilote1 + ", pilote2=" + pilote2
	            + ", pilote3=" + pilote3 + ", pilote4=" + pilote4 
	            + ", quantiteProduitAvant=" + quantiteProduitAvant
                + ", quantiteDefectueuseAvant=" + quantiteDefectueuseAvant
                + ", quantiteProduitApres=" + quantiteProduitApres
                + ", quantiteDefectueuseApres=" + quantiteDefectueuseApres
                + ", cloturisationPourcentage=" + cloturisationPourcentage
                + ", qrqcNonCloture=" + qrqcNonCloture
                + ", qrqcNonEscalade=" + qrqcNonEscalade
                + "]";
	}

	public QRQC(Long id, String nomPrenom, String responsable, java.util.Date date, String produit, String ref,
            String tracabilite, String problemDescription, int quantiteisole, int nbrPieceDefaut, String niveau,
            String quoi, String qui, String combien, String quand, String qu, String comment, String pourquoi,
            String isolationEmplacement, String isolationDetails, java.util.Date isolationDate, boolean isolationOuiNon,
            String repassageEmplacement, String repassageDetails, java.util.Date repassageDate, boolean repassageOuiNon,
            String alerteProcessEmplacement, String alerteProcessDetails, java.util.Date alerteProcessDate,
            boolean alerteProcessOuiNon, String alerteMaintenanceEmplacement, String alerteMaintenanceDetails,
            java.util.Date alerteMaintenanceDate, boolean alerteMaintenanceOuiNon, String alerteFournisseurEmplacement,
            String alerteFournisseurDetails, java.util.Date alerteFournisseurDate, boolean alerteFournisseurOuiNon,
            String changementLotEmplacement, String changementLotDetails, java.util.Date changementLotDate,
            boolean changementLotOuiNon, String dtcOuvertEmplacement, String dtcOuvertDetails,
            java.util.Date dtcOuvertDate, boolean dtcOuvertOuiNon, String traitementAlerteDetails,
            java.util.Date traitementAlerteDate, String traitementAlerteDetails2,
            // Cause de non detection and cause de l'occurrence for P1 to P5
            String p1CauseNonDetection, String p1CauseOccurrence,
            String p2CauseNonDetection, String p2CauseOccurrence,
            String p3CauseNonDetection, String p3CauseOccurrence,
            String p4CauseNonDetection, String p4CauseOccurrence,
            String p5CauseNonDetection, String p5CauseOccurrence,
            // Adding actionCloturee1 to actionCloturee4
            boolean actionCloturee1, boolean actionCloturee2,
            boolean actionCloturee3, boolean actionCloturee4,
            // Adding corrective1 to corrective4
            String corrective1, String corrective2,
            String corrective3, String corrective4,
            // Adding preventive1 to preventive4
            String preventive1, String preventive2,
            String preventive3, String preventive4,
            // Adding pilote1 to pilote4
            String pilote1, String pilote2,
            String pilote3, String pilote4,
            // Adding actions1 to actions4
            String actions1, String actions2,
            String actions3, String actions4,
            int quantiteProduitAvant, int quantiteDefectueuseAvant, int quantiteProduitApres,
            int quantiteDefectueuseApres, String cloturisationPourcentage, boolean qrqcNonCloture,
            boolean qrqcNonEscalade) {
            
    super();
    this.id = id;
    NomPrenom = nomPrenom;
    Responsable = responsable;
    Date = date;
    Produit = produit;
    Ref = ref;
    this.tracabilite = tracabilite;
    ProblemDescription = problemDescription;
    this.quantiteisole = quantiteisole;
    this.nbrPieceDefaut = nbrPieceDefaut;
    Niveau = niveau;
    Quoi = quoi;
    Qui = qui;
    Combien = combien;
    Quand = quand;
    Qu = qu;
    Comment = comment;
    Pourquoi = pourquoi;
    this.isolationEmplacement = isolationEmplacement;
    this.isolationDetails = isolationDetails;
    this.isolationDate = isolationDate;
    this.isolationOuiNon = isolationOuiNon;
    this.repassageEmplacement = repassageEmplacement;
    this.repassageDetails = repassageDetails;
    this.repassageDate = repassageDate;
    this.repassageOuiNon = repassageOuiNon;
    this.alerteProcessEmplacement = alerteProcessEmplacement;
    this.alerteProcessDetails = alerteProcessDetails;
    this.alerteProcessDate = alerteProcessDate;
    this.alerteProcessOuiNon = alerteProcessOuiNon;
    this.alerteMaintenanceEmplacement = alerteMaintenanceEmplacement;
    this.alerteMaintenanceDetails = alerteMaintenanceDetails;
    this.alerteMaintenanceDate = alerteMaintenanceDate;
    this.alerteMaintenanceOuiNon = alerteMaintenanceOuiNon;
    this.alerteFournisseurEmplacement = alerteFournisseurEmplacement;
    this.alerteFournisseurDetails = alerteFournisseurDetails;
    this.alerteFournisseurDate = alerteFournisseurDate;
    this.alerteFournisseurOuiNon = alerteFournisseurOuiNon;
    this.changementLotEmplacement = changementLotEmplacement;
    this.changementLotDetails = changementLotDetails;
    this.changementLotDate = changementLotDate;
    this.changementLotOuiNon = changementLotOuiNon;
    this.dtcOuvertEmplacement = dtcOuvertEmplacement;
    this.dtcOuvertDetails = dtcOuvertDetails;
    this.dtcOuvertDate = dtcOuvertDate;
    this.dtcOuvertOuiNon = dtcOuvertOuiNon;
    this.traitementAlerteDetails = traitementAlerteDetails;
    this.traitementAlerteDate = traitementAlerteDate;
    this.traitementAlerteDetails2 = traitementAlerteDetails2;
    // Cause de non detection and cause de l'occurrence for P1 to P5
    this.p1CauseNonDetection = p1CauseNonDetection;
    this.p1CauseOccurrence = p1CauseOccurrence;
    this.p2CauseNonDetection = p2CauseNonDetection;
    this.p2CauseOccurrence = p2CauseOccurrence;
    this.p3CauseNonDetection = p3CauseNonDetection;
    this.p3CauseOccurrence = p3CauseOccurrence;
    this.p4CauseNonDetection = p4CauseNonDetection;
    this.p4CauseOccurrence = p4CauseOccurrence;
    this.p5CauseNonDetection = p5CauseNonDetection;
    this.p5CauseOccurrence = p5CauseOccurrence;
    // Adding actionCloturee1 to actionCloturee4
    this.actionCloturee1 = actionCloturee1;
    this.actionCloturee2 = actionCloturee2;
    this.actionCloturee3 = actionCloturee3;
    this.actionCloturee4 = actionCloturee4;
    // Adding corrective1 to corrective4
    this.corrective1 = corrective1;
    this.corrective2 = corrective2;
    this.corrective3 = corrective3;
    this.corrective4 = corrective4;
    // Adding preventive1 to preventive4
    this.preventive1 = preventive1;
    this.preventive2 = preventive2;
    this.preventive3 = preventive3;
    this.preventive4 = preventive4;
    // Adding pilote1 to pilote4
    this.pilote1 = pilote1;
    this.pilote2 = pilote2;
    this.pilote3 = pilote3;
    this.pilote4 = pilote4;
    // Adding actions1 to actions4
    this.actions1 = actions1;
    this.actions2 = actions2;
    this.actions3 = actions3;
    this.actions4 = actions4;
    this.quantiteProduitAvant = quantiteProduitAvant;
    this.quantiteDefectueuseAvant = quantiteDefectueuseAvant;
    this.quantiteProduitApres = quantiteProduitApres;
    this.quantiteDefectueuseApres = quantiteDefectueuseApres;
    this.cloturisationPourcentage = cloturisationPourcentage;
    this.qrqcNonCloture = qrqcNonCloture;
    this.qrqcNonEscalade = qrqcNonEscalade;
}


	//public QRQC(Long id, String nomPrenom, String responsable, java.util.Date date, String produit, String ref,
         //   String tracabilite, String problemDescription, int quantiteisole, int nbrPieceDefaut, String niveau,
           // String quoi, String qui, String combien, String quand, String qu, String comment, String pourquoi) {
    //super();
    //this.id = id;
    //NomPrenom = nomPrenom;
    //Responsable = responsable;
    //Date = date;
   // Produit = produit;
    //Ref = ref;
    //this.tracabilite = tracabilite;
    //ProblemDescription = problemDescription;
    //this.quantiteisole = quantiteisole;
    //this.nbrPieceDefaut = nbrPieceDefaut;
   // Niveau = niveau;
   //Quoi = quoi;
///Qui= qui;
//Combien= combien;
//Quand= quand;
//Qu= qu;
//Comment= comment;
//Pourquoi= pourquoi;
//}

public QRQC() {
    super();
    // TODO Auto-generated constructor stub
}
}

