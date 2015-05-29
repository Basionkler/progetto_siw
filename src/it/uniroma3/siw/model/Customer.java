package it.uniroma3.siw.model;

import javax.persistence.*;

import java.util.*;

@Entity
@Table(name="tb_customer")
@NamedQuery(name = "findAllCustomers", query = "SELECT c FROM tb_customer c")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private Date dateOfBirth;

	@Column(nullable = false)
	private Date registrationDate;

	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Address address;

	@OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Order> orders;

	// Costruttori

	public Customer() {

	}

	public Customer(Long id, String firstName, String lastName, String email,
			Date dateOfBirth, Date registrationDate,
			Address address, List<Order> orders) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.registrationDate = registrationDate;
		this.address = address;
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

	public void setOrder(List<Order> orders) {
		this.orders = orders;
	}
	
	public void addOrder(Order order) {
		if(order != null) this.orders.add(order);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email +", dateOfBirth=" + dateOfBirth + ", registrationDate="
				+ registrationDate + ", address=" + address + ", orders="
				+ orders + "]";
	}
}