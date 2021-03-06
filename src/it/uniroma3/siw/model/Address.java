package it.uniroma3.siw.model;

import javax.persistence.*;

@Entity
@Table(name="tb_address")
@NamedQuery(name = "findAllAddress", query = "SELECT a FROM tb_address a")
public class Address {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String zipCode;

    @OneToOne
    private Customer customer;

//costruttori
   
    public Address() {		
	}
    
    public Address(String street, String city, String state, String zipCode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
    
//getter & setter

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Long getId() {
		return id;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public Customer getCustomer() {
		return customer;
	}


	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(street);
		s.append(" ");
		s.append(city);
		s.append(" ");
		s.append(zipCode);
		return s.toString();
	}

    
    

}