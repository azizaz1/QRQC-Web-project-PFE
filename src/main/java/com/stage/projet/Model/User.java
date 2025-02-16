package com.stage.projet.Model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "Utilisateur",
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "username"
				+ ""),
		@UniqueConstraint(columnNames = "email") 
	})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class User implements Serializable {
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	  private String username;
	  private String email;
	  private String password;
	  private boolean isActive;
	  private String role;
	// Session-related fields
	    private String sessionId;
	    private LocalDateTime lastLogin;
	    private LocalDateTime sessionExpiration;

	  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	    private List<Stage> stages;
	  
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public LocalDateTime getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}
	public LocalDateTime getSessionExpiration() {
		return sessionExpiration;
	}
	public void setSessionExpiration(LocalDateTime sessionExpiration) {
		this.sessionExpiration = sessionExpiration;
	}
	@Override
	public String toString() {
	    return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
	            + ", isActive=" + isActive + ", role=" + role
	            + ", sessionId=" + sessionId + ", lastLogin=" + lastLogin + ", sessionExpiration=" + sessionExpiration
	            + "]";
	}

	public User(long id, String username, String email, String password, boolean isActive, String role,
	            String sessionId, LocalDateTime lastLogin, LocalDateTime sessionExpiration) {
	    this.id = id;
	    this.username = username;
	    this.email = email;
	    this.password = password;
	    this.isActive = isActive;
	    this.role = role;
	    this.sessionId = sessionId;
	    this.lastLogin = lastLogin;
	    this.sessionExpiration = sessionExpiration;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	  
}