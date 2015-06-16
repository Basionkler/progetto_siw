package it.uniroma3.siw.model;

import javax.persistence.*;

@Entity
@Table(name="tb_provider")
@NamedQuery(name = "findAllProviders", query = "SELECT p FROM tb_provider p")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long provider_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String vatin;

    @OneToOne
    private Address address;

    /*
    @JoinTable(name="providers2products", 
    		joinColumns = @JoinColumn(name="provider_id"), 
    		inverseJoinColumns = @JoinColumn(name="product_id"))
    @ManyToMany(targetEntity = it.uniroma3.siw.model.Product.class)
    private List<Product> products = new ArrayList<Product>();*/

    
    //Getter&Setter
	public Long getId() {
		return provider_id;
	}

	public void setId(Long id) {
		this.provider_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVatin() {
		return vatin;
	}

	public void setVatin(String vatin) {
		this.vatin = vatin;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	/* 
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	*/
}