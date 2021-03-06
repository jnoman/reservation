package beans;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Reservation {
	@EmbeddedId
    private ReservationId id;
	@NotNull
	private int etat;
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	public Reservation() {
		super();
		this.etat = 0;
	}
	public ReservationId getId() {
		return id;
	}
	public void setId(ReservationId id) {
		this.id = id;
	}
	public Reservation(ReservationId id) {
		super();
		this.id = id;
		this.etat = 0;
	}
}