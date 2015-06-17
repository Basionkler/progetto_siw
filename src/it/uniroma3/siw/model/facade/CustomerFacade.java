package it.uniroma3.siw.model.facade;

import it.uniroma3.siw.model.Address;
import it.uniroma3.siw.model.Customer;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless(name = "customerFacade")
public class CustomerFacade {
	
	@PersistenceContext(unitName = "products-unit")
	private EntityManager em;
	
	public Customer createCustomer(String firstName, String lastName, String email, String password, Date dateOfBirth, Address address) {
		Date registrationDate = new Date();
		Customer c = new Customer(firstName, lastName, email, password, dateOfBirth, registrationDate, address);
		address.setCustomer(c);
		em.persist(c);
		return c;
	}
	
	public Customer getCustomer(Long id){
		Customer customer = em.find(Customer.class, id);
		return customer;
	}

	public Customer getCustomer(String email) {
		TypedQuery<Customer> query = em.createNamedQuery("findCustomerByEmail", Customer.class);
		query.setParameter("email", email);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public boolean controllaPassword(Customer c, String password) {
		return c.getPassword().equals(password);
	}

}

