package it.uniroma3.siw.model;

import javax.persistence.*;

import java.util.*;

/* TEMPORANEA
 * VALUTARE SE INSERIRE CLASSE ASTRATTA UTENTE
 * DA FAR ESTENDERE A CUSTOMER E ADMIN,
 * NEL CODICE EVIDENZIO GLI ATTRIBUTI DA INSERIRE
 * EVENTUALMENTE NELLA CLASSE ASTRATTA
 */
@Entity
@Table(name="tb_admin")
@NamedQuery(name = "findAllAdmins", query = "SELECT a FROM tb_admin a")
public class Admin {

	// ATTRIBUTI DA INSERIRE NELLA CLASSE ASTRATTA

	//INIZIO
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String email;

	//private String password ?

	@Column(nullable = false)
	private Date dateOfBirth;

	@Column(nullable = false)
	private Date registrationDate;

	//FINE

	@Column
	private ProductCatalogue currentCatalogue;

	@Column
	private List<ProductCatalogue> allCatalogueList;

	@Column
	private List<Customer> customerRegistry;

	public Admin(Long id, String firstName, String lastName, String email,
			Date dateOfBirth, Date registrationDate, List<Customer> customerRegistry, ProductCatalogue currentCatalogue) {

		//super(id, firstName, lastName, email, dateOfBirth, registrationDate);

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.registrationDate = registrationDate;

		this.currentCatalogue = currentCatalogue;
		this.allCatalogueList = new ArrayList<ProductCatalogue>();
		this.customerRegistry = customerRegistry;

	}

	/**
	 * il cliente viene aggiunto all'anagrafica clienti dall'admin
	 * @param c	
	 */
	public void addCustomerToRegistry(Customer c) {
		if( c != null) this.customerRegistry.add(c);
	}

	/* GETTERS AND SETTERS */
	// EVENTUALMENTE DA INSERIRE NELLA CLASSE ASTRATTA USER
	//INIZIO

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

	// FINE

	public ProductCatalogue getCurrentCatalogue() {
		return currentCatalogue;
	}

	public void setCurrentCatalogue(ProductCatalogue currentCatalogue) {
		this.currentCatalogue = currentCatalogue;
	}

	public List<ProductCatalogue> getAllCatalogueList() {
		return allCatalogueList;
	}

	public void setAllCatalogueList(List<ProductCatalogue> allCatalogueList) {
		this.allCatalogueList = allCatalogueList;
	}

	public List<Customer> getCustomerRegistry() {
		return customerRegistry;
	}

	public void setCustomerRegistry(List<Customer> customerRegistry) {
		this.customerRegistry = customerRegistry;
	}

}
