package com.youcode.reservation.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.youcode.reservation.beans.Utilisateur;
import com.youcode.reservation.dao.UtilisateurRepository;

public class UtilisateurMetierImpl implements UtilisateurMetier {
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public void inscription(Utilisateur user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		utilisateurRepository.save(user);
	}

}
