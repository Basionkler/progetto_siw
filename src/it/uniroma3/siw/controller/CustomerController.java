 package it.uniroma3.siw.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.uniroma3.siw.model.Address;
import it.uniroma3.siw.model.Customer;
import it.uniroma3.siw.model.Order;
import it.uniroma3.siw.model.facade.AddressFacade;
import it.uniroma3.siw.model.facade.CustomerFacade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="customerController")
@SessionScoped
public class CustomerController{
	
	/* Address Creator */
	private String street;
	private String city;
	private String state;
	private String zipCode;
	
	/* Customer Creator */
	protected String email;
	protected String password;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Date registrationDate;
    private Address address;
    private List<Order> orders;
    private Customer customer;
    
    @EJB(beanName = "customerFacade")
	private CustomerFacade customerFacade;
    
    @EJB(beanName = "addressFacade")
    private AddressFacade addressFacade;
    
    public String createCustomer() {
    	this.address = addressFacade.createAddress(street, city, state, zipCode);
		this.customer = customerFacade.createCustomer(firstName, lastName, email, password, dateOfBirth, address, new ArrayList<>());
		return "customer";
	}
    
	public String login() {
		this.customer = customerFacade.getCustomer(this.email);
		if(this.customer!=null && customerFacade.controllaPassword(this.customer,this.password)){
			return "customerProfile";
		} else {
			return "error";
		}
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public AddressFacade getAddressFacade() {
		return addressFacade;
	}

	public void setAddressFacade(AddressFacade addressFacade) {
		this.addressFacade = addressFacade;
	}
}
