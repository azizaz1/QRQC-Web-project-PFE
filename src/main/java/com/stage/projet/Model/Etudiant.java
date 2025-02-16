package com.stage.projet.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "etudiant")
public class Etudiant {
	 private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long  id;
	  private String nom;
	  private String prenom;
	  private String mail;
	  private String Identif;
	  private int password;
	  
	 
	 
	public Long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = (long) id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getIdentif() {
		return Identif;
	}
	public void setIdentif(String identif) {
		Identif = identif;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", Identif=" + Identif
				+ ", password=" + password + "]";
	}
	public Etudiant(long id, String nom, String prenom, String mail, String identif, int password) {
		super();
		this.id = (long) id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		Identif = identif;
		this.password = password;
	}
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

}
