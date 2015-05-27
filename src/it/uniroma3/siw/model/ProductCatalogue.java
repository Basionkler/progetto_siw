package it.uniroma3.siw.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/* Classe temporanea, valutarne l'utilizzo */
@Entity
@Table(name="tb_product_catalogue")
@NamedQuery(name = "findAllCatalogue", query = "SELECT pc FROM tb_product_catalogue pc")
public class ProductCatalogue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private Date creationDate;
	
	@ManyToMany(mappedBy = "product_catalogue")
	List<Product> productList;
	
	/* TODO Variabile d'istanza admin? o controllo sui diritti di modifica (Se utente è admin, puoModificare = true)?*/
	
	public ProductCatalogue(){}
	
	public ProductCatalogue(Date creationDate, List<Product> productList) {
		
		this.creationDate = creationDate;
		this.productList = productList;
		
	}
	
	public void addProductToCatalogue(Product p) {
		if (p != null) this.productList.add(p);
	}
	
	/** GETTERS AND SETTERS **/

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

}
