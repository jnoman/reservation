package beans;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class Utilisateur {
	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	private String nom;
	@NotNull
	private String prenom;
	@Email
	@NotNull
	@Column(unique=true)
	private String email;
	@NotNull
	private String password;
	@NotNull
	private String role;
	@NotNull
	private int active;
	private Integer nbrReservation;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public Integer getNbrReservation() {
		return nbrReservation;
	}
	public void setNbrReservation(Integer nbrReservation) {
		this.nbrReservation = nbrReservation;
	}
	public Utilisateur(String nom, String prenom, String email, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.role = "user";
		this.active=0;
		this.nbrReservation = 0;
	}
	public Utilisateur() {
		super();
	}
	
	
}