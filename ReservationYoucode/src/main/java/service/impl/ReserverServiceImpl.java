package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import beans.Reserver;
import beans.Utilisateur;
import dao.ReserverDao;
import service.ReserverService;

@Service("reserverService")
@Transactional(propagation = Propagation.SUPPORTS, noRollbackFor = Exception.class)
public class ReserverServiceImpl implements ReserverService {

	@Autowired
	ReserverDao reserverDao;
	
	@Transactional
	@Override
	public void create(Reserver reserver) {
		reserverDao.create(reserver);
	}
	
	@Transactional
	@Override
	public void update(Reserver reserver) {
		reserverDao.update(reserver);
	}

	@Transactional
	@Override
	public Reserver find(Long id) {
		return reserverDao.find(id);
	}
	
	@Transactional
	@Override
	public List<Reserver> getReserverWeek() {
		return reserverDao.getReserverWeek();
	}
	
	@Transactional
	@Override
	public List<Reserver> getReserverProchain() {
		return reserverDao.getReserverProchain();
	}
	
	@Transactional
	@Override
	public List<Reserver> getReserverProchainUser(Utilisateur user) {
		return reserverDao.getReserverProchainUser(user);
	}

}
