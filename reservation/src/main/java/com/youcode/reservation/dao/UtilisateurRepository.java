package com.youcode.reservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.youcode.reservation.beans.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	public Utilisateur findByEmail(String email);
}
