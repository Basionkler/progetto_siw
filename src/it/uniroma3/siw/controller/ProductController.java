package it.uniroma3.siw.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import it.uniroma3.siw.model.Product;
import it.uniroma3.siw.model.facade.ProductFacade;

@ManagedBean
public class ProductController {

	@EJB
	private ProductFacade productFacade;
	private String name;
	private Float price;
	private String description;
	private String code;
	private Product product;

	public String createProduct() {
		this.product = productFacade.createProduct(name, code, price, description);
		return "product"; 
	}

	//getter e setter
	public ProductFacade getProductFacade() {
		return productFacade;
	}

	public void setProductFacade(ProductFacade productFacade) {
		this.productFacade = productFacade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
