package it.uniroma3.siw.controller;

import it.uniroma3.siw.model.Product;
import it.uniroma3.siw.model.facade.ProductFacade;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean(name="productController")
public class ProductController {
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String name;
	private Float price;
	private String description;
	private String code;
	private Product product;
	private Integer quantity;
	private List<Product> products;
	
	@EJB(beanName="productFacade")
	private ProductFacade productFacade;
	
	public String createProduct() {
		this.product = productFacade.createProduct(name, code, price, description, quantity);
		return "product"; 
	}
	
	public String listProducts() {
		
		this.products = productFacade.getAllProducts();
		return "products"; 
	}

	public String findProduct() {
		this.product = productFacade.getProduct(id);
		return "product";
	}
	
	public String findProduct(Long id) {
		this.product = productFacade.getProduct(id);
		return "product";
	}
	
//Getter&Setter
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Product> getProducts() {
		if (products == null || products.size() == 0) {
			this.listProducts();
		}
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void setProductFacade(ProductFacade productFacade) {
		this.productFacade = productFacade;
	}
	
	public int getSize() {
		if (this.products == null) return 0;
		return this.products.size();
	}
}


