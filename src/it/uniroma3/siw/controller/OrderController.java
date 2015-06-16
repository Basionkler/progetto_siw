package it.uniroma3.siw.controller;

import it.uniroma3.siw.model.Customer;
import it.uniroma3.siw.model.Order;
import it.uniroma3.siw.model.OrderLine;
import it.uniroma3.siw.model.Product;
import it.uniroma3.siw.model.facade.OrderFacade;
import it.uniroma3.siw.model.facade.ProductFacade;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ejb.SessionContext;

@ManagedBean(name="orderController")
@SessionScoped
public class OrderController {
	
	private Order ordineCorrente;
	private Integer quantitaProdottoCorrente;
	private Product prodottoCorrente;
	private Customer c;
	
	@EJB(beanName="productFacade")
	private OrderFacade orderFacade;
	
	@Resource
	private SessionContext context;

	
	public String createOrder() {
		this.ordineCorrente = orderFacade.createOrder(c);
		return "order";
	}
	
	public String addProduct(){
		this.ordineCorrente.getOrderLines().add(orderFacade.CreaLineOrdine(this.prodottoCorrente,this.quantitaProdottoCorrente));
		orderFacade.updateOrder(this.ordineCorrente);
		return null;
	}
	

}
