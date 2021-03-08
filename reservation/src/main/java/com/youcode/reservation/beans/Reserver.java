package com.youcode.reservation.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Reserver {
	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty
	@NotNull
	private Date dateReserver;
	@NotEmpty
	@NotNull
	private int nombrePlace;
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
	public Reserver(Date dateReserver, int nombrePlace) {
		super();
		this.dateReserver = dateReserver;
		this.nombrePlace = nombrePlace;
	}
	public Reserver() {
		super();
	}
}