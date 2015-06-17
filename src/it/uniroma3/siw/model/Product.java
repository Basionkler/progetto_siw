package it.uniroma3.siw.model;

import javax.persistence.*;

@Entity
@Table(name="tb_product")
@NamedQuery(name = "findAllProducts", query = "SELECT p FROM Product p")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Lob
	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private Float price;
	
	@Column(nullable = false)
	private Integer quantitaDisponibile;

	@Column(nullable = false)
	private String code;

	@Column(nullable = true)
	@OneToOne
	private OrderLine orderLine;


	/*@Column(nullable = true)
	@ManyToMany(targetEntity = it.uniroma3.siw.model.Provider.class, mappedBy = "products")
	private List<Provider> providers;*/
	//Costruttore

	public Product() {
    }

	public Product(String name, Float price, String description, String code, Integer quantity) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.code = code;
        this.quantitaDisponibile = quantity;
       // this.providers = new ArrayList<Provider>();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public OrderLine getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(OrderLine orderLine) {
		this.orderLine = orderLine;
	}

	/*
	public List<Provider> getProviders() {
		return providers;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}
	*/
	@Override
	public String toString() {
		return "[name=" + name + ", description=" + description
				+ ", price=" + price + "]\n";
	}

}