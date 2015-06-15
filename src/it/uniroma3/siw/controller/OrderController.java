package it.uniroma3.siw.controller;

import it.uniroma3.siw.model.Customer;
import it.uniroma3.siw.model.Order;
import it.uniroma3.siw.model.facade.OrderFacade;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ejb.SessionContext;

@ManagedBean(name="orderController")
@SessionScoped
public class OrderController {
	
	private Order order;
	
	private Customer c;
	
	@Resource
	private SessionContext context;
	
	@EJB(beanName="orderFacade")
	private OrderFacade orderFacade;
	
	public String createOrder() {
		this.order = orderFacade.createOrder(c);
		return "order";
	}
	

}
