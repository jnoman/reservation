package com.youcode.reservation.beans;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Entity
public class ListEmail {
	@NotEmpty
	@NotNull
	@Email
	private String email;
	@NotEmpty
	@NotNull
	private String reference;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public ListEmail(String email, String reference) {
		super();
		this.email = email;
		this.reference = reference;
	}
	public ListEmail() {
		super();
	}
	

}