package com.youcode.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.youcode.reservation.beans.Utilisateur;
import com.youcode.reservation.dao.UtilisateurRepository;

@Controller
public class IndexController {
	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/inscription")
	public String inscription() {
		return "inscription";
	}
	@RequestMapping(value="/inscription", method = RequestMethod.POST)
	public String createNewUser(Model model, @RequestParam(name = "email") String email) {
		Utilisateur user = utilisateurRepository.findByEmail(email);
		if(user != null) {
			System.out.println("aaaaaa");
		} else {
			model.addAttribute("erreur", "l'email existe déjà");
		}
		return "inscription";
	}
}
