package com.stage.projet.Model;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "stage")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Stage {
	 private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  private String nom_entreprise;
	  private String TitreStage;
	  private String description;
	    private Date DateIncident;
	    private String lieuIncident;
	    private String equipementComposant;
	    private String dommagesMateriels;
	    private String graviteIncident;
	    private String facteursContributifs;
	    private String actionCorrective;
	    private String imageRapport;
	    
	  @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  
	  private Formulaire formulaire;
	  
	  
	  @OneToMany(mappedBy = "stage", fetch=FetchType.EAGER)
  	  private List<Formulaire> formulaire1 = new ArrayList<>();
	  
	  @ManyToOne(fetch = FetchType.LAZY)

	    private User user;
	  
	  @OneToMany(mappedBy = "stage", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	    private List<QRQC> qrqcs = new ArrayList<>();
	  
	public Long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = (long) id;
	}
	public String getNom_entreprise() {
		return nom_entreprise;
	}
	public void setNom_entreprise(String nom_entreprise) {
		this.nom_entreprise = nom_entreprise;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitreStage() {
		return TitreStage;
	}
	public void setTitreStage(String titreStage) {
		TitreStage = titreStage;
	}
	 public Date getDateIncident() {
	        return DateIncident;
	    }

	    public void setDateIncident(Date dateIncident) {
	        this.DateIncident = dateIncident;
	    }

	    
	    public String getLieuIncident() {
	        return lieuIncident;
	    }

	    public void setLieuIncident(String lieuIncident) {
	        this.lieuIncident = lieuIncident;
	    }

	    public String getEquipementComposant() {
	        return equipementComposant;
	    }

	    public void setEquipementComposant(String equipementComposant) {
	        this.equipementComposant = equipementComposant;
	    }

	    public String getDommagesMateriels() {
	        return dommagesMateriels;
	    }

	    public void setDommagesMateriels(String dommagesMateriels) {
	        this.dommagesMateriels = dommagesMateriels;
	    }

	    public String getGraviteIncident() {
	        return graviteIncident;
	    }

	    public void setGraviteIncident(String graviteIncident) {
	        this.graviteIncident = graviteIncident;
	    }

	    public String getFacteursContributifs() {
	        return facteursContributifs;
	    }

	    public void setFacteursContributifs(String facteursContributifs) {
	        this.facteursContributifs = facteursContributifs;
	    }

	    public String getActionCorrective() {
	        return actionCorrective;
	    }

	    public void setActionCorrective(String actionCorrective) {
	        this.actionCorrective = actionCorrective;
	    }
	    
	public String getImageRapport() {
			return imageRapport;
		}
		public void setImageRapport(String imageRapport) {
			this.imageRapport = imageRapport;
		}
		 public User getUser() {
		        return user;
		    }

		    // Setter method for user attribute
		    public void setUser(User user) {
		        this.user = user;
		    }
		   
	@Override
	public String toString() {
	    return "Stage [id=" + id + ", nom_entreprise=" + nom_entreprise + ", TitreStage=" + TitreStage
	            + ", Description=" + description + ", DateIncident=" + DateIncident
	            + ", lieuIncident=" + lieuIncident + ", equipementComposant=" + equipementComposant
	            + ", dommagesMateriels=" + dommagesMateriels + ", graviteIncident=" + graviteIncident
	            + ", facteursContributifs=" + facteursContributifs + ", actionCorrective=" + actionCorrective
	            + ", imageRapport=" + imageRapport + "]";
	}

	
	public Stage(long id, String nom_entreprise, String titreStage, String Description, Date dateIncident, 
            String lieuIncident, String equipementComposant, String dommagesMateriels, String graviteIncident,
            String facteursContributifs, String actionCorrective, String imageRapport) {
   super();
   this.id = id;
   this.nom_entreprise = nom_entreprise;
   this.TitreStage = titreStage;
   this.description = Description;
   this.DateIncident = dateIncident;
   this.lieuIncident = lieuIncident;
   this.equipementComposant = equipementComposant;
   this.dommagesMateriels = dommagesMateriels;
   this.graviteIncident = graviteIncident;
   this.facteursContributifs = facteursContributifs;
   this.actionCorrective = actionCorrective;
   this.imageRapport = imageRapport;
}


	public Stage() {
		super();
		// TODO Auto-generated constructor stub
	}
	  

}
