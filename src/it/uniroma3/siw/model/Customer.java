package it.uniroma3.siw.model;

import javax.persistence.*;

import java.util.*;

@Entity
@Table(name="tb_customer")
@NamedQueries({
		@NamedQuery(name = "findAllCustomers", query = "SELECT c FROM Customer c"),
		@NamedQuery(name = "findCustomerByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email")
})
public class Customer{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(unique=true, nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@Temporal(TemporalType.DATE)
	private Date registrationDate;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Address address;

	@OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Order> orders;

	// Costruttori
	public Customer(String firstName, String lastName, String email,
			String password, Date dateOfBirth, Date registrationDate,
			Address address, List<Order> orders) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.registrationDate = registrationDate;
		this.address = address;
		this.orders = orders;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	
}