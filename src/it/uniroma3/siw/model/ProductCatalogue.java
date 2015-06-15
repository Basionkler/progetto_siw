package it.uniroma3.siw.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@Column(nullable=true)
	@ManyToMany(targetEntity= Product.class, fetch = FetchType.EAGER, mappedBy="tb_product_catalogue")
	List<Product> productList;
	
	/* TODO Variabile d'istanza admin? o controllo sui diritti di modifica (Se utente è admin, puoModificare = true)?*/
	
	public ProductCatalogue(){}
	
	public ProductCatalogue(Date creationDate, List<Product> productList) {
		
		this.creationDate = creationDate;
		//this.productList = productList;
		
	}
	
	public void addProduct(Product p) {
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
		//this.productList = productList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((productList == null) ? 0 : productList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductCatalogue other = (ProductCatalogue) obj;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (productList == null) {
			if (other.productList != null)
				return false;
		} else if (!productList.equals(other.productList))
			return false;
		return true;
	}

}
