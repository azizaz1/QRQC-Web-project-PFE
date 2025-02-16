package com.stage.projet.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
	 private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	  private String identif_admin;
	  private String password;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdentif_admin() {
		return identif_admin;
	}
	public void setIdentif_admin(String identif_admin) {
		this.identif_admin = identif_admin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", identif_admin=" + identif_admin + ", password=" + password + "]";
	}
	public Admin(Long id, String identif_admin, String password) {
		super();
		this.id = id;
		this.identif_admin = identif_admin;
		this.password = password;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	  
}
