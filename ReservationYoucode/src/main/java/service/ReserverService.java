package service;

import java.util.List;

import beans.Reserver;
import beans.Utilisateur;

public interface ReserverService {
	public void create(Reserver reserver);
	public void update(Reserver reserver);
	public Reserver find(Long id);
	public List<Reserver> getReserverWeek();
	public List<Reserver> getReserverProchain();
	public List<Reserver> getReserverProchainUser(Utilisateur user);
}
