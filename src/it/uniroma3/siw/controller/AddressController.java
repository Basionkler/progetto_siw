package it.uniroma3.siw.controller;

import it.uniroma3.siw.model.Address;
import it.uniroma3.siw.model.Customer;
import it.uniroma3.siw.model.Provider;
import it.uniroma3.siw.model.facade.AddressFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="addressController")
public class AddressController {

	private Long id;
	private String street;
	private String city;
	private String state;
	private String zipCode;
	private String country;
	private Customer customer;
	private Provider provider;
	private Address address;

	@EJB
	private AddressFacade addressFacade;

	public String createAddress() {
		this.address = addressFacade.createAddress(street, city, state, zipCode, country);
		return "customer"; 
	}

	public String findAddress() {
		this.address = addressFacade.getAddress(id);
		return "product";
	}


//Getter&Setter

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public AddressFacade getAddressFacade() {
		return addressFacade;
	}

	public void setAddressFacade(AddressFacade addressFacade) {
		this.addressFacade = addressFacade;
	}
}

