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

import beans.Utilisateur;

import beans.Reserver;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:WEB-INF/dispatcher-config.xml" })
public class ReserverServiceTest {

	@Autowired
	private ReserverService reserverService;
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@Test
	public void testFind() {
		Reserver reserver = reserverService.find(10L);
		assertNotNull(reserver);
	}
	
	@Test 
	public void testGetReserverWeek() {
		List<Reserver> list = reserverService.getReserverWeek();
		assertEquals(list.size(), 7);
	}
	
	@Test 
	public void testGetReserverProchain() {
		List<Reserver> list = reserverService.getReserverProchain();
		assertNotEquals(list.size(), 0);
	}
	
	@Test 
	public void testGetReserverProchainUser() {
		Utilisateur user = utilisateurService.find(2L);
		List<Reserver> list = reserverService.getReserverProchainUser(user);
		assertNotEquals(list.size(), 0);
	}
}
