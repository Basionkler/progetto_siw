package it.uniroma3.siw.model.facade;

import java.util.Date;

import it.uniroma3.siw.model.Customer;
import it.uniroma3.siw.model.Order;
import it.uniroma3.siw.model.OrderLine;
import it.uniroma3.siw.model.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless(name="orderFacade")
public class OrderFacade {
	
	@PersistenceContext(unitName ="products-unit")
	private EntityManager em;
	
	public Order createOrder(Customer c) {
		Order order = new Order(c);
		try {
		c.addOrder(order);
		} catch (Exception e) {
			System.out.println(c);
			System.out.println(order);
		}
		em.persist(order);
		return order;
	}
	
	public Order closeOrder(Order o) {
		o.setClosingDate(new Date());
		em.merge(o);
		return o;
	}
	
	public Order evadeOrder(Order o) {
		o.setProcessingDate(new Date());
		em.merge(o);
		return o;
	}
	
	public Order getOrder(Long id) {
		Order order = em.find(Order.class, id);
		return order;
	}
	
	public Order getOrdineAperto(Customer c){
		try {
			return (Order)em.createQuery("SELECT o FROM Order o WHERE o.customer = :c AND o.closingDate is null")
					.setParameter("c", c).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public OrderLine createOrderLine(Product prodottoCorrente, Integer quantitaProdottoCorrente) {
		OrderLine ol = new OrderLine(quantitaProdottoCorrente, prodottoCorrente);
		em.persist(ol);
		return ol;
	}

	public void updateOrder(Order order) {
		em.merge(order);		
	}	

}
