package it.uniroma3.siw.model;

import it.uniroma3.siw.abstr.User;

import javax.persistence.*;

import java.util.*;

@Entity
@Table(name="tb_customer")
@NamedQuery(name = "findAllCustomers", query = "SELECT c FROM tb_customer c")
public class Customer extends User{
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Address address;

	@OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Order> orders;

	// Costruttori

	public Customer(Long id, String firstName, String lastName, String email, String password,
			Date dateOfBirth, Date registrationDate,
			Address address, List<Order> orders) {
		super(id, firstName, lastName, email, password, dateOfBirth, registrationDate);

		this.address = address;
		this.orders = orders;
	}
	

	@Override
	public boolean isAdmin() {
		return super.isAdmin;
	}
	
	/**
	 * da "siw-progetto-1.pptx"
	 * @param order aggiunge un nuovo ordine
	 */
	public void addOrder(Order order) {
		if(order != null) this.orders.add(order);
	}
	
	/**
	 * da "siw-progetto-1.pptx"
	 * il cliente deve poter consultare il catalogo prodotti
	 * @param pc catalogo dei prodotti
	 */
	public void consultCatalogue(ProductCatalogue pc) {
		pc.getProductList();
	}
	
	
	// GETTERS AND SETTERS

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}