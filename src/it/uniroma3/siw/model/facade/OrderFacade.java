package it.uniroma3.siw.model.facade;

import java.util.Date;
import java.util.List;

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

	public Order closeOrder(Order ordineCorrente) {
		ordineCorrente.setClosingDate(new Date());
		em.merge(ordineCorrente);
		return ordineCorrente;
	}

	public List<Order> getOrdiniDaEvadere(){
		return em.createQuery("SELECT o FROM Order o WHERE o.processingDate is null AND o.closingDate is NOT null", Order.class).getResultList();
	}
	
	public Order evadeOrder(Order ordineCorrente) {
		List<OrderLine> orderLines = em.createQuery("SELECT ol FROM OrderLine ol WHERE ol.order = :o",OrderLine.class)
				.setParameter("o", ordineCorrente).getResultList();

		if(controlloDisponibilitaProdotti(orderLines)){
			rimuoviProdottiDalCatalogo(orderLines);
			ordineCorrente.setProcessingDate(new Date());
			em.merge(ordineCorrente);
		}
		
		return ordineCorrente;
	}

	private boolean controlloDisponibilitaProdotti(List<OrderLine> orderLines) {
		for(OrderLine ol:orderLines){
			if(orderLines != null && ol.getQuantity() >= ol.getProduct().getQuantitaDisponibile()){
				return false;
			}
		}
		
		return true;		
	}

	private void rimuoviProdottiDalCatalogo(List<OrderLine> orderLines) {
		for(OrderLine ol:orderLines){
			ol.getProduct().setQuantitaDisponibile(ol.getProduct().getQuantitaDisponibile()-ol.getQuantity());
			em.merge(ol.getProduct());
		}
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

	public OrderLine findProdottoInOrdine(Product p, Order ordineCorrente) {
		try {
			return (OrderLine)em.createQuery("SELECT ol FROM OrderLine ol WHERE ol.order = :o AND ol.product = :p")
					.setParameter("o", ordineCorrente).setParameter("p", p).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public OrderLine createOrderLine(Product prodottoCorrente, Integer quantitaProdottoCorrente, Order ordineCorrente) {
		OrderLine ol = new OrderLine(quantitaProdottoCorrente, prodottoCorrente);
		ol.setOrder(ordineCorrente);
		ordineCorrente.addOrderLine(ol);
		em.persist(ol);
		return ol;
	}


	public void updateOrder(Order order) {
		em.merge(order);		
	}	

	public List<OrderLine> getAllLinesOrder(Order order) {
		return em.createQuery("SELECT ol FROM OrderLine ol WHERE ol.order = :order", OrderLine.class)
				.setParameter("order", order).getResultList();
	}

}
