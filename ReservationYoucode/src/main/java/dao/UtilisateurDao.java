package dao;

import java.util.List;

import beans.Utilisateur;
import beans.UtilisateurConnection;

public interface UtilisateurDao {
	public void create(Utilisateur User);
	public void update(Utilisateur User);
	public Utilisateur find(Long id);
	public Utilisateur login(UtilisateurConnection user);
	public List<Utilisateur> getAllApprenant();
	public Utilisateur findByEmail(String email);
	public List<Utilisateur> getAllApprenantInvalid();
}
