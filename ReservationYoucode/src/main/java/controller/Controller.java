package controller;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import beans.Utilisateur;
import beans.UtilisateurConnection;
import service.UtilisateurService;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	UtilisateurService utilisateurService;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/connexion")
	public String login() {
		return "connexion";
	}
	
	@PostMapping("/connexion")
	public String connexion(Model model, UtilisateurConnection user, HttpSession httpSession) {
		Utilisateur utilisateur = utilisateurService.login(user);
		if(utilisateur != null) {
			if (utilisateur.getActive() == 1) {
				httpSession.setAttribute("logged", utilisateur);
				return "redirect:/";
			} else if (utilisateur.getActive() == 0) {
				model.addAttribute("erreur", "Votre demande d'inscription n'a pas encore été acceptée");
			} else if (utilisateur.getActive() == 2) {
				model.addAttribute("erreur", "Votre demande d'inscription a été rejetée");
			}
		} else {
			model.addAttribute("erreur", "Email ou mot de passe est incorrect");
		}
		return "connexion";
	}
	
	@RequestMapping("/inscription")
	public String inscription() {
		return "inscription";
	}
	
	@RequestMapping(value = "/inscription", method = RequestMethod.POST)
	public String inscriptionAprenenat(Model model, @RequestParam(name = "email") String email, @RequestParam(name = "nom") String nom , 
			@RequestParam(name = "prenom") String prenom , @RequestParam(name = "password") String password) {
		Utilisateur user = utilisateurService.findByEmail(email);
		if(user != null) {
			model.addAttribute("erreur", "l'email existe déjà");
		} else {
			try {
				Utilisateur utilisateur = new Utilisateur(nom, prenom, email, BCrypt.hashpw(password, BCrypt.gensalt()));
				utilisateurService.create(utilisateur);
				model.addAttribute("succes", "l'inscription est terminé avec succès");
				return "connexion";
			} catch (Exception e) {
				model.addAttribute("erreur", e);
			}
		}
		System.out.println(user);
		return "inscription";
	}
	
	@RequestMapping("/deconnexion")
	public String deconnexion(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:/";
	}
	
	
	
	@RequestMapping("/refused")
	public String refused() {
		return "refused";
	}
}
