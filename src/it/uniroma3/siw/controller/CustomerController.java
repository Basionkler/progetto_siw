 package it.uniroma3.siw.controller;

import java.util.Date;
import java.util.List;

import it.uniroma3.siw.model.Address;
import it.uniroma3.siw.model.Customer;
import it.uniroma3.siw.model.Order;
import it.uniroma3.siw.model.facade.CustomerFacade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="cController")
@SessionScoped
public class CustomerController {
	
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date dateOfBirth;
    private Date registrationDate;
    private Address address;
    private List<Order> orders;
    private Customer customer;
    
    @EJB
	private CustomerFacade customerFacade;
    
    public String createCustomer() {
		this.customer = customerFacade.createCustomer(firstName, lastName, email, password, dateOfBirth, address, orders);
		return "newAddress"; 
	}

	public String login() {
		Customer c = customerFacade.getCustomer(this.email);
		if(c!=null && customerFacade.controllaPassword(c,this.password)){
			return "welcome";
		} else {
			return "error";
		}
		
//		Customer c = CustomerFacade.getCustomer((long) 2);
//		if (c.password.equals(this.password)) {
//			return "welcome";
//		} else {
//			return "error";
//		}
	}
    
//Getter&Setter    
    
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CustomerFacade getCustomerFacade() {
		return customerFacade;
	}

	public void setCustomerFacade(CustomerFacade customerFacade) {
		this.customerFacade = customerFacade;
	}
}
