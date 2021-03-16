package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import beans.Reservation;
import beans.ReservationId;
import beans.Reserver;
import beans.Utilisateur;
import service.ReservationService;
import service.ReserverService;
import service.UtilisateurService;

@org.springframework.stereotype.Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UtilisateurService utilisateurService;
	
	@Autowired
	ReserverService reserverService;
	
	@Autowired
	ReservationService reservationService;
	
	@RequestMapping("/demandesAcces")
	public String demandesAcces(Model model, HttpSession httpSession) {
		System.out.println(reserverService.getReserverProchainUser((Utilisateur)httpSession.getAttribute("logged")).size());
		model.addAttribute("listReserver", reserverService.getReserverProchainUser((Utilisateur)httpSession.getAttribute("logged")));
		model.addAttribute("listDemande", reservationService.getByUtilisateur((Utilisateur)httpSession.getAttribute("logged")));
		return "user/demandesAcces";
	}
	
	@RequestMapping(value="/demandesAcces", method = RequestMethod.POST)
	public void AjouterdemandesAcces(Model model, HttpSession httpSession, @RequestParam(name = "id_reserver") Long id_reserver) {
		Utilisateur user = (Utilisateur)httpSession.getAttribute("logged");
		Reserver reserver= reserverService.find(id_reserver);
		System.out.println(reserver.getNombrePlace());
		reservationService.create(new Reservation(new ReservationId(user, reserver)));
		model.addAttribute("succes", "l'ajout de demande d'accés est terminé avec succès");
		demandesAcces(model, httpSession);
	}
}
