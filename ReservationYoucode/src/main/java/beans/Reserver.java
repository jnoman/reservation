package beans;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Reserver {
	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	private Date dateReserver;
	@NotNull
	private int nombrePlace;
	@NotNull
	private String duree;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateReserver() {
		return dateReserver;
	}
	public void setDateReserver(Date dateReserver) {
		this.dateReserver = dateReserver;
	}
	public int getNombrePlace() {
		return nombrePlace;
	}
	public void setNombrePlace(int nombrePlace) {
		this.nombrePlace = nombrePlace;
	}
	public String getDuree() {
		return duree;
	}
	public void setDuree(String duree) {
		this.duree = duree;
	}
	public Reserver(Date dateReserver, int nombrePlace, String duree) {
		super();
		this.dateReserver = dateReserver;
		this.nombrePlace = nombrePlace;
		this.duree = duree;
	}
	public Reserver() {
		super();
	}
}