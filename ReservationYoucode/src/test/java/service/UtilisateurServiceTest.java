package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import beans.Utilisateur;
import beans.UtilisateurConnection;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:WEB-INF/dispatcher-config.xml" })
public class UtilisateurServiceTest {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	
	
	@Test
	public void testFind() {
		Utilisateur user = utilisateurService.find(1L);
		assertNotNull(user);
	}
	
	@Test
	public void testLogin() {
		Utilisateur user = utilisateurService.login(new UtilisateurConnection("admin@gmail.com", "aaaaaaaa"));
		assertNotNull(user);
		assertEquals(user.getRole(),"admin");
	}
	
	@Test
	public void testGetAllApprenant() {
		List<Utilisateur> list = utilisateurService.getAllApprenant();
		assertNotNull(list);
		assertEquals(list.get(0).getRole(),"user");
	}
	
	@Test
	public void testFindByEmail() {
		Utilisateur user = utilisateurService.findByEmail("admin@gmail.com");
		assertNotNull(user);
	}
	
	@Test
	public void testGetAllApprenantInvalid() {
		List<Utilisateur> list = utilisateurService.getAllApprenantInvalid();
		assertNotNull(list);
	}

}
