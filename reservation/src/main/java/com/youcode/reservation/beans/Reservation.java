package com.youcode.reservation.beans;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Reservation {
	@EmbeddedId
    private Reservation id;
	@ManyToOne
	private Utilisateur user;
	@ManyToOne
	private Reserver Reserver;
	@NotEmpty
	@NotNull
	private int etat;
	public Utilisateur getUser() {
		return user;
	}
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	public Reserver getReserver() {
		return Reserver;
	}
	public void setReserver(Reserver reserver) {
		Reserver = reserver;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	public Reservation(Utilisateur user, com.youcode.reservation.beans.Reserver reserver) {
		super();
		this.user = user;
		Reserver = reserver;
		this.etat = 0;
	}
	

}