package it.uniroma3.siw.model.facade;

import it.uniroma3.siw.model.Address;
import it.uniroma3.siw.model.Order;
import it.uniroma3.siw.model.Customer;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless(name = "uFacade")
public class CustomerFacade {
	
	@PersistenceContext(unitName = "userFacade")
	private EntityManager em;
	
	public Customer createCustomer(String firstName, String lastName, String email, String password, Date dateOfBirth, Address address, List<Order> orders) {
		Date registrationDate = Calendar.getInstance().getTime();
		Customer c = new Customer(firstName, lastName, email, password, dateOfBirth, registrationDate, address, orders);
		return c;

	}
	
	public Customer getCustomer(Long id){
		Customer customer = em.find(Customer.class, id);
		return customer;
	}

}

