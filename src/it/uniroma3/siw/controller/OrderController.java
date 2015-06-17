package it.uniroma3.siw.controller;

import java.util.List;

import it.uniroma3.siw.model.Customer;
import it.uniroma3.siw.model.Order;
import it.uniroma3.siw.model.OrderLine;
import it.uniroma3.siw.model.Product;
import it.uniroma3.siw.model.facade.OrderFacade;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="orderController")
@SessionScoped
public class OrderController {
	
	private Integer quantity;
	private Order ordineCorrente;
	private List<OrderLine> orderlines;
	private List<Order> orderToEvade;
	private Customer c;
	
	@EJB(beanName="orderFacade")
	private OrderFacade orderFacade;
	
	@PostConstruct
	public void init() {
		this.quantity = 1;
	}
	
	public String createOrder(Customer c) {
		this.ordineCorrente = orderFacade.getOrdineAperto(c);
		if(this.ordineCorrente==null)
			this.ordineCorrente = orderFacade.createOrder(c);
		return "newOrder";
	}
	
	public String closeOrder() {
		orderFacade.closeOrder(this.ordineCorrente);
		return "customerProfile";
	}
	
	public void evadeOrder(Order ordinecorrente) {
		orderFacade.evadeOrder(ordinecorrente);
	}
	
	public List<Order> getOrderToEvade() {
		return this.orderToEvade = orderFacade.getOrdiniDaEvadere();
	}
	
	public String addProduct(Product p){
		OrderLine ol = orderFacade.findProdottoInOrdine(p,ordineCorrente);
		if(ol==null) this.ordineCorrente.getOrderLines().add(orderFacade.createOrderLine(p, this.quantity, this.ordineCorrente));
		else ol.setQuantity(quantity);
		orderFacade.updateOrder(this.ordineCorrente);
		return "newOrder";
	}
	
	public String listOrdersRows() {
		this.orderlines = orderFacade.getAllLinesOrder(this.ordineCorrente);
		return "orderReview";
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Order getOrdineCorrente() {
		return ordineCorrente;
	}

	public void setOrdineCorrente(Order ordineCorrente) {
		this.ordineCorrente = ordineCorrente;
	}

	public Customer getC() {
		return c;
	}

	public void setC(Customer c) {
		this.c = c;
	}

	public OrderFacade getOrderFacade() {
		return orderFacade;
	}

	public void setOrderFacade(OrderFacade orderFacade) {
		this.orderFacade = orderFacade;
	}

	public List<OrderLine> getOrderlines() {
		return orderlines;
	}

	public void setOrderlines(List<OrderLine> orderlines) {
		this.orderlines = orderlines;
	}

	public void setOrderToEvade(List<Order> orderToEvade) {
		this.orderToEvade = orderToEvade;
	}

	
}
