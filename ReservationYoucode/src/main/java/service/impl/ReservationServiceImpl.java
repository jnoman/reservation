package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import beans.Reservation;
import beans.Reserver;
import beans.Utilisateur;
import dao.ReservationDao;
import service.ReservationService;

@Service("reservationService")
@Transactional(propagation = Propagation.SUPPORTS, noRollbackFor = Exception.class)
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	ReservationDao reservationDao;
	
	@Transactional
	@Override
	public void create(Reservation reservation) {
		reservationDao.create(reservation);
	}
	
	@Transactional
	@Override
	public void update(Reservation reservation) {
		reservationDao.update(reservation);
	}

	@Transactional
	@Override
	public List<Reservation> getByUtilisateur(Utilisateur utilisateur) {
		return reservationDao.getByUtilisateur(utilisateur);
	}

	@Transactional
	@Override
	public List<Reservation> getByReserver(Reserver reserver) {
		return reservationDao.getByReserver(reserver);
	}

	@Transactional
	@Override
	public Reservation getByReserverUtilisateur(Reserver reserver, Utilisateur utilisateur) {
		return reservationDao.getByReserverUtilisateur(reserver, utilisateur);
	}

	@Transactional
	@Override
	public void refuseAllReservation(Reserver reserver) {
		reservationDao.refuseAllReservation(reserver);
	}

}
