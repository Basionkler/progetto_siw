package it.uniroma3.siw.model;

import javax.persistence.*;

@Entity
@Table(name="tb_order_line")
@NamedQuery(name = "findAllOrderLines", query = "SELECT p FROM tb_order_line p")
public class OrderLine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private Float unitPrice;

	@Column(nullable = false)
	private Integer quantity;

	@ManyToOne
	private Order order;

	@OneToOne
	private Product product;
	
	public OrderLine(Integer quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
		this.unitPrice = product.getPrice();
	}
	
	public double getSubTotal() {
		return unitPrice*quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}