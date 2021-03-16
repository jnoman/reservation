package dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beans.Reserver;
import beans.Utilisateur;
import dao.ReserverDao;

@Repository("reserverDao")
public class ReserverDaoImpl implements ReserverDao {

	@Autowired
	SessionFactory sessionFactory;
	
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(Reserver reserver) {
		currentSession().save(reserver);
	}
	
	@Override
	public void update(Reserver reserver) {
		currentSession().update(reserver);
	}

	@Override
	public Reserver find(Long id) {
		return currentSession().get(Reserver.class, id);
	}

	@Override
	public List<Reserver> getReserverWeek() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		cal.add(Calendar.DATE, 7);
		Date firstDate = cal.getTime();
		cal.add(Calendar.DATE, 6);
		cal.set(Calendar.MILLISECOND, 90);
		Date lastDate = cal.getTime();
		return currentSession().createQuery("from Reserver where dateReserver >= :debut and dateReserver <= :fin",
				Reserver.class).setParameter("debut", firstDate).setParameter("fin", lastDate).list();
	}

	@Override
	public List<Reserver> getReserverProchain() {
		return currentSession().createQuery("from Reserver where nombrePlace > 0 and dateReserver >= current_date",Reserver.class).list();
	}

	@Override
	public List<Reserver> getReserverProchainUser(Utilisateur user) {
		return currentSession().createQuery("from Reserver where id not in (select R.id.reserver.id from Reservation R "
				+ "where R.id.user=:user) order by dateReserver",Reserver.class).setParameter("user", user).list();
		
//		return currentSession().createQuery("select R from Reserver R left join Reservation Re on R=Re.id.reserver "
//				+ "where  Re.id.user is null and R.nombrePlace > 0 and R.dateReserver >= current_date "
//				+ "order by R.dateReserver",Reserver.class).list();
	}

}
