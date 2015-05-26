package it.uniroma3.siw.model;

import javax.persistence.*;

import java.util.*;

@Entity
@Table(name="tb_order")
@NamedQuery(name = "findAllOrder", query = "SELECT p FROM tb_order p")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private Date creationDate;
	
	private Date closingDate;
	
	private Date processingDate;

	@ManyToOne
	private Customer customer;

	@OneToMany(fetch=FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	private List<OrderLine> orderLines;

	//Getter&Setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}
	
	public Date getProcessingDate() {
		return processingDate;
	}

	public void setProcessingDate(Date processingDate) {
		this.processingDate = processingDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

}