package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import beans.Reservation;
import beans.Reserver;
import beans.Utilisateur;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:WEB-INF/dispatcher-config.xml" })
public class ReservationServiceTest {
	
	@Autowired 
	private ReservationService reservationService;
	
	@Autowired
	private ReserverService reserverService;
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@Test
	public void testGetByUtilisateur() {
		Utilisateur user = utilisateurService.find(2L);
		List<Reservation> list = reservationService.getByUtilisateur(user);
		assertNotEquals(list.size(), 0);
	}
	
	@Test
	public void testGetByReserver() {
		Reserver reserver = reserverService.find(10L);
		System.out.println(reserver.getNombrePlace());
		List<Reservation> list = reservationService.getByReserver(reserver);
		assertEquals(list.size(), 0);
	}
	
	@Test
	public void testGetByReserverUtilisateur() {
		Utilisateur user = utilisateurService.find(2L);
		Reserver reserver = reserverService.find(10L);
		System.out.println(reserver.getNombrePlace());
		Reservation resservation = reservationService.getByReserverUtilisateur(reserver, user);
		assertNotNull(resservation);
	}

}
