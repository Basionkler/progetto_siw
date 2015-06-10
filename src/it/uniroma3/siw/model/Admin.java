package it.uniroma3.siw.model;

import it.uniroma3.siw.abstr.User;

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
public class Admin extends User{

	@Column
	private ProductCatalogue currentCatalogue;

	@Column //L'admin si deve ricordare di tutti i cataloghi o solo di quello corrente?
	private List<ProductCatalogue> allCatalogueList;

	@Column
	private List<Customer> customerRegistry;

	public Admin(Long id, String firstName, String lastName, String email, String password,
			Date dateOfBirth, Date registrationDate, List<Customer> customerRegistry, ProductCatalogue currentCatalogue) {

		super(id, firstName, lastName, email, password, dateOfBirth, registrationDate);

		this.currentCatalogue = currentCatalogue;
		this.allCatalogueList = new ArrayList<ProductCatalogue>();
		this.customerRegistry = customerRegistry;

	}
	
	public boolean isAdmin() {
		return super.isAdmin = true;
	}
	

	/** 
	 * da "siw-progetto-1.pptx"
	 * il cliente viene aggiunto all'anagrafica clienti dall'admin
	 * @param c	
	 */
	public void addCustomerToRegistry(Customer c) {
		if(c != null) this.customerRegistry.add(c);
	}
	
	/**
	 * da "siw-progetto-1.pptx"
	 * Inserimento di un prodotto nel catalogo
	 * @param p
	 */
	public void addProductToCatalogue(Product p) {
		if(p != null) this.currentCatalogue.addProduct(p);
	}
	
	/****** CODICE DI PROVA ******/
	
	/* aggiorno solo il catalogo corrente, questo viene in automatico
	 * inserito nel registro di tutti i  cataloghi
	 */
	private void addCatalogueToList(ProductCatalogue c) {
		if(!this.allCatalogueList.contains(c))
				this.allCatalogueList.add(c);
	}
	public void setCurrentCatalogue(ProductCatalogue c) {
		this.currentCatalogue = c;
		this.addCatalogueToList(c);
	}
	
	/***** FINE CODICE DI PROVA *****/

	public ProductCatalogue getCurrentCatalogue() {
		return currentCatalogue;
	}

	/*
	 * Temporaneamente commentato per codice di prova più in alto
	 * 
	public void setCurrentCatalogue(ProductCatalogue currentCatalogue) {
		this.currentCatalogue = currentCatalogue;
	} */

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
