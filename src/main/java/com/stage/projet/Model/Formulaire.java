package com.stage.projet.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "formulaire")
public class Formulaire {
	 private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	  private String nom_prenom;
	  private String mail;
	  private String specialité;
	  private String dossier;
@ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  
	  private QRQC emploi;
@ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)

private Stage stage;
	public Long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = (long) id;
	}
	public String getNom_prenom() {
		return nom_prenom;
	}
	public void setNom_prenom(String nom_prenom) {
		this.nom_prenom = nom_prenom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getSpecialité() {
		return specialité;
	}
	public void setSpecialité(String specialité) {
		this.specialité = specialité;
	}
	public String getDossier() {
		return dossier;
	}
	public void setDossier(String dossier) {
		this.dossier = dossier;
	}
	@Override
	public String toString() {
		return "Formulaire [id=" + id + ", nom_prenom=" + nom_prenom + ", mail=" + mail + ", specialité=" + specialité
				+ ", dossier=" + dossier + "]";
	}
	public Formulaire(long id, String nom_prenom, String mail, String specialité, String dossier) {
		super();
		this.id = (long) id;
		this.nom_prenom = nom_prenom;
		this.mail = mail;
		this.specialité = specialité;
		this.dossier = dossier;
	}
	public Formulaire() {
		super();
		// TODO Auto-generated constructor stub
	}

}
