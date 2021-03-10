package com.youcode.reservation.beans;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class ReservationId implements Serializable {
	@ManyToOne
	@JoinColumn(name="user_id")
	private Utilisateur user;
	@ManyToOne
	@JoinColumn(name="reserver_id")
	private Reserver Reserver;
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
	public ReservationId(Utilisateur user, com.youcode.reservation.beans.Reserver reserver) {
		super();
		this.user = user;
		Reserver = reserver;
	}
	
}
