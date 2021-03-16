package beans;


import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@SuppressWarnings("serial")
public class ReservationId implements Serializable {
	@ManyToOne
	@JoinColumn(name="user_id")
	private Utilisateur user;
	@ManyToOne
	@JoinColumn(name="reserver_id")
	private Reserver reserver;
	public Utilisateur getUser() {
		return user;
	}
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	public Reserver getReserver() {
		return reserver;
	}
	public void setReserver(Reserver reserver) {
		this.reserver = reserver;
	}
	public ReservationId(Utilisateur user, Reserver reserver) {
		super();
		this.user = user;
		this.reserver = reserver;
	}
	public ReservationId() {
		super();
	}
	
}
