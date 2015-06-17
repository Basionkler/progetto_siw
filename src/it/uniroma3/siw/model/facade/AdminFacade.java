package it.uniroma3.siw.model.facade;

import it.uniroma3.siw.model.Admin;

import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless(name = "adminFacade")
public class AdminFacade {

	@PersistenceContext(unitName = "products-unit")
	private EntityManager em;

	public Admin createAdmin(String nickname, String email, String password) {
		Admin a = new Admin(nickname, email, password);
		em.persist(a);
		return a;
	}

	public Admin getAdmin(Long id) {
		Admin admin = em.find(Admin.class, id);
		return admin;
	}
	
	public Admin getAdminByNickName(String nickname) {
		TypedQuery<Admin> query = em.createNamedQuery("findAdminByNickname", Admin.class);
		query.setParameter("nickname", nickname);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	/*
	public Admin getAdminByEmail(String email) {
		TypedQuery<Admin> query = em.createNamedQuery("findAdminByEmail", Admin.class);
		query.setParameter("email", email);
		return query.getSingleResult();
	}*/

	public boolean controllaPassword(Admin a, String password) {
		return a.getPassword().equals(password);

	}
}
