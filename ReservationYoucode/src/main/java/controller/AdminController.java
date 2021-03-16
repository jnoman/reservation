package controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import beans.Reservation;
import beans.Reserver;
import beans.Utilisateur;
import service.ReservationService;
import service.ReserverService;
import service.UtilisateurService;

@org.springframework.stereotype.Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	UtilisateurService utilisateurService;

	@Autowired
	ReserverService reserverService;
	
	@Autowired
	ReservationService reservationService;
	
	@RequestMapping("/demandeInscription")
	public String demandeInscription(Model model) {
		model.addAttribute("listUser", utilisateurService.getAllApprenantInvalid());
		return "admin/demandeInscription";
	}
	
	@RequestMapping(value = "/demandeInscription", method = RequestMethod.POST, params = "accepter")
	public String accepterInscription(Utilisateur user) {
		user = utilisateurService.find(user.getId());
		user.setActive(1);
		utilisateurService.update(user);
		return "redirect:/admin/demandeInscription";
	}
	
	@RequestMapping(value = "/demandeInscription", method = RequestMethod.POST, params = "refuser")
	public String refuserInscription(Utilisateur user) {
		user = utilisateurService.find(user.getId());
		user.setActive(2);
		utilisateurService.update(user);
		return "redirect:/admin/demandeInscription";
	}
	
	@RequestMapping("/demandeAcces")
	public String demandeAcces(Model model) {
		model.addAttribute("listReserver", reserverService.getReserverProchain());
		return "admin/demandeAcces";
	}
	
	@RequestMapping(value="/demandeAcces", method = RequestMethod.POST, params = "selectionner")
	public void selectionnerDemandeAcces(Model model, @RequestParam(name = "id_reserver") Long id_reserver) {
		model.addAttribute("listDemande", reservationService.getByReserver(reserverService.find(id_reserver)));
		model.addAttribute("succes", id_reserver);
		demandeAcces(model);
	}
	
	@RequestMapping(value="/demandeAcces", method = RequestMethod.POST, params = "accepter")
	public void accepterDemandeAcces(Model model, @RequestParam(name = "user_id") Long user_id, @RequestParam(name = "reserver_id") Long reserver_id) {
		Utilisateur utilisateur = utilisateurService.find(user_id);
		Reserver reserver = reserverService.find(reserver_id);
		Reservation reservation = reservationService.getByReserverUtilisateur(reserver, utilisateur);
		reservation.setEtat(1);
		reserver.setNombrePlace(reserver.getNombrePlace()-1);
		reserverService.update(reserver);
		reservationService.update(reservation);
		if (reserver.getNombrePlace() == 0) {
			reservationService.refuseAllReservation(reserver);
		}
		selectionnerDemandeAcces(model, reserver_id);
	}
	
	@RequestMapping(value="/demandeAcces", method = RequestMethod.POST, params = "refuser")
	public void refuserDemandeAcces(Model model, @RequestParam(name = "user_id") Long user_id, @RequestParam(name = "reserver_id") Long reserver_id) {
		Utilisateur utilisateur = utilisateurService.find(user_id);
		Reserver reserver = reserverService.find(reserver_id);
		Reservation reservation = reservationService.getByReserverUtilisateur(reserver, utilisateur);
		reservation.setEtat(2);
		reservationService.update(reservation);
		selectionnerDemandeAcces(model, reserver_id);
	}
	
	@RequestMapping("/nombrePlace")
	public String nombrePlace(Model model) {
		model.addAttribute("listReserver", reserverService.getReserverWeek());
		return "admin/nombrePlace";
	}
	
	@RequestMapping(value = "/nombrePlace", method = RequestMethod.POST, params = "ajouter")
	public void ajouterNombrePlace(Model model, @RequestParam(name = "lundi") int lundi, @RequestParam(name = "mardi") int mardi,
			@RequestParam(name = "mercredi") int mercredi, @RequestParam(name = "jeudi") int jeudi, @RequestParam(name = "vendredi") 
			int vendredi, @RequestParam(name = "samedi") int samedi, @RequestParam(name = "dimanche") int dimanche) {
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MILLISECOND, 50);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		cal.add(Calendar.DATE, 7);
		reserverService.create(new Reserver(cal.getTime(), lundi, "17h-20h"));
		cal.add(Calendar.DATE, 1);
		reserverService.create(new Reserver(cal.getTime(), mardi, "17h-20h"));
		cal.add(Calendar.DATE, 1);
		reserverService.create(new Reserver(cal.getTime(), mercredi, "17h-20h"));
		cal.add(Calendar.DATE, 1);
		reserverService.create(new Reserver(cal.getTime(), jeudi, "17h-20h"));
		cal.add(Calendar.DATE, 1);
		reserverService.create(new Reserver(cal.getTime(), vendredi, "17h-20h"));
		cal.add(Calendar.DATE, 1);
		reserverService.create(new Reserver(cal.getTime(), samedi, "9h-20h"));
		cal.add(Calendar.DATE, 1);
		reserverService.create(new Reserver(cal.getTime(), dimanche, "9h-20h"));
		
		model.addAttribute("succes", "l'ajout du nombre de places pour la semaine prochaine est terminé avec succès");
		nombrePlace(model);
	}
	
	@RequestMapping(value = "/nombrePlace", method = RequestMethod.POST, params = "modifier")
	public void modifierNombrePlace(Model model, @RequestParam(name = "lundi") int lundi, @RequestParam(name = "mardi") int mardi,
			@RequestParam(name = "mercredi") int mercredi, @RequestParam(name = "jeudi") int jeudi, @RequestParam(name = "vendredi") 
			int vendredi, @RequestParam(name = "samedi") int samedi, @RequestParam(name = "dimanche") int dimanche) {
		
		List<Reserver> listReserver = reserverService.getReserverWeek();
		listReserver.get(0).setNombrePlace(lundi);
		listReserver.get(1).setNombrePlace(mardi);
		listReserver.get(2).setNombrePlace(mercredi);
		listReserver.get(3).setNombrePlace(jeudi);
		listReserver.get(4).setNombrePlace(vendredi);
		listReserver.get(5).setNombrePlace(samedi);
		listReserver.get(6).setNombrePlace(dimanche);
		
		reserverService.update(listReserver.get(0));
		reserverService.update(listReserver.get(1));
		reserverService.update(listReserver.get(2));
		reserverService.update(listReserver.get(3));
		reserverService.update(listReserver.get(4));
		reserverService.update(listReserver.get(5));
		reserverService.update(listReserver.get(6));
		
		model.addAttribute("succes", "la modification du nombre de places pour la semaine prochaine est terminé avec succès");
		nombrePlace(model);
	}
	
	@RequestMapping("/historique")
	public String historique(Model model) {
		model.addAttribute("listUser", utilisateurService.getAllApprenant());
		return "admin/historique";
	}
	
	@RequestMapping(value="/historique", method = RequestMethod.POST)
	public void selectionnerHistorique(Model model, @RequestParam(name = "id_user") Long id_user) {
		model.addAttribute("listReservation", reservationService.getByUtilisateur(utilisateurService.find(id_user)));
		model.addAttribute("succes", id_user);
		historique(model);
	}
}
