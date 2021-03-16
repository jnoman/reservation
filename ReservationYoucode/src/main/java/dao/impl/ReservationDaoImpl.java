package dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beans.Reservation;
import beans.Reserver;
import beans.Utilisateur;
import dao.ReservationDao;

@Repository("reservationDao")
public class ReservationDaoImpl implements ReservationDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(Reservation reservation) {
		currentSession().save(reservation);
	}

	@Override
	public void update(Reservation reservation) {
		currentSession().update(reservation);
	}

	@Override
	public List<Reservation> getByUtilisateur(Utilisateur utilisateur) {
		return currentSession().createQuery("from Reservation where id.user = :utilisateur order by id.reserver.dateReserver desc" ,Reservation.class).setParameter("utilisateur", utilisateur).list();
	}

	@Override
	public List<Reservation> getByReserver(Reserver reserver) {
		return currentSession().createQuery("from Reservation where id.reserver = :reserver and etat=0 order by id.user.nbrReservation" ,Reservation.class).setParameter("reserver", reserver).list();
	}

	@Override
	public Reservation getByReserverUtilisateur(Reserver reserver, Utilisateur utilisateur) {
		return currentSession().createQuery("from Reservation where id.reserver = :reserver and id.user=:user" ,Reservation.class).setParameter("reserver", reserver).setParameter("user", utilisateur).uniqueResult();
	}

	@Override
	public void refuseAllReservation(Reserver reserver) {
		currentSession().createQuery("UPDATE Reservation SET etat=2 where etat=0 and id.reserver=:reserver").setParameter("reserver", reserver).executeUpdate();
	}

}
