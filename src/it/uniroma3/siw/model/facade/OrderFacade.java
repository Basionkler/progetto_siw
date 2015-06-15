package it.uniroma3.siw.model.facade;

import java.util.Date;

import it.uniroma3.siw.model.Customer;
import it.uniroma3.siw.model.Order;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name="orderFacade")
public class OrderFacade {
	
	@PersistenceContext(unitName ="products-unit")
	private EntityManager em;
	
	public Order createOrder(Customer c) {
		Order order = new Order(c);
		em.persist(order);
		return order;
	}
	
	public Order closeOrder(Order o) {
		o.setClosingDate(new Date());
		em.persist(o);
		return o;
	}
	
	public Order evadeOrder(Order o) {
		o.setProcessingDate(new Date());
		em.persist(o);
		return o;
	}
	
	public Order getOrder(Long id) {
		Order order = em.find(Order.class, id);
		return order;
	}
	
	

}
