package it.uniroma3.siw.model;

import javax.persistence.*;

/* TEMPORANEA
 * VALUTARE SE INSERIRE CLASSE ASTRATTA UTENTE
 * DA FAR ESTENDERE A CUSTOMER E ADMIN,
 * NEL CODICE EVIDENZIO GLI ATTRIBUTI DA INSERIRE
 * EVENTUALMENTE NELLA CLASSE ASTRATTA
 */
@Entity
@Table(name="tb_admin")
@NamedQueries({
	@NamedQuery(name = "findAllAdmins", query = "SELECT a FROM Admin a"),
	@NamedQuery(name = "findAdminByEmail", query = "SELECT a FROM Admin a WHERE a.email = :email"),
	@NamedQuery(name = "findAdminByNickname", query = "SELECT a FROM Admin a WHERE a.nickname = :nickname")
})
public class Admin{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nickname;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String password;


	public Admin(String nickname, String email, String password) {

		this.nickname = nickname;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

}
