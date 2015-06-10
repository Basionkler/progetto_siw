package it.uniroma3.siw.model.facade;

import it.uniroma3.siw.abstr.User;
import it.uniroma3.siw.model.Admin;
import it.uniroma3.siw.model.Customer;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless(name = "uFacade")
public class UserFacade {
	
	@PersistenceContext(unitName = "userFacade")
	private EntityManager em;
	
	public User createUser(Long id, String firstName, String lastName, String email, String password,
			Date dateOfBirth, Date registrationDate) {
		//User u = new Admin(id, firstName, lastName, email, password, dateOfBirth, registrationDate);
		// TODO
		return null;

	}
	
	public User getUser(Long id) {
		User user = em.find(User.class, id);
		return user;
	}

}
