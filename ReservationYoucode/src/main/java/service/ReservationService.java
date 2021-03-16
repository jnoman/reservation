package service;

import java.util.List;

import beans.Reservation;
import beans.Reserver;
import beans.Utilisateur;

public interface ReservationService {
	public void create(Reservation reservation);
	public void update(Reservation reservation);
	public List<Reservation> getByUtilisateur(Utilisateur utilisateur);
	public List<Reservation> getByReserver(Reserver reserver);
	public Reservation getByReserverUtilisateur(Reserver reserver, Utilisateur utilisateur);
	public void refuseAllReservation(Reserver reserver);
}
