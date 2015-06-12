package it.uniroma3.siw.model.facade;

import java.util.Calendar;

import it.uniroma3.siw.model.Order;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class OrderFacade {
	
	@PersistenceContext(name ="orderFacade")
	private EntityManager em;
	
	public Order createOrder() {
		Order order = new Order();
		order.setCreationDate(Calendar.getInstance().getTime());
		em.persist(order);
		return order;
	}
	
	public Order closeOrder(Order o) {
		o.setClosingDate(Calendar.getInstance().getTime());
		em.persist(o);
		return o;
	}
	
	public Order evadeOrder(Order o) {
		o.setProcessingDate(Calendar.getInstance().getTime());
		em.persist(o);
		return o;
	}
	
	public Order getOrder(Long id) {
		Order order = em.find(Order.class, id);
		return order;
	}
	
	

}
