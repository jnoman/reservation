package com.youcode.reservation.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Utilisateur {
	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty
	@NotNull
	private String nom;
	@NotEmpty
	@NotNull
	private String prenom;
	@Email
	@NotEmpty
	@NotNull
	@Column(unique=true)
	private String email;
	@NotEmpty
	@NotNull
	private String password;
	@NotEmpty
	@NotNull
	private String role;
	@NotEmpty
	@NotNull
	private boolean valid;
	@NotEmpty
	@NotNull
	private int active;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public Utilisateur(String nom, String prenom, String email, String password, String role, boolean valid) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.role = role;
		this.valid = valid;
		this.active=0;
	}
	public Utilisateur() {
		super();
	}
	
	
}