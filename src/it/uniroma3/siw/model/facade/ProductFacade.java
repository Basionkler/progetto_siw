package it.uniroma3.siw.model.facade;

import it.uniroma3.siw.model.Product;

import javax.ejb.Stateless;
import javax.persistence.*;


@Stateless(name="pFacade")
public class ProductFacade {

	@PersistenceContext(unitName = "unit-jee-es1")
	private EntityManager em;

	public Product createProduct(String name, String code, Float price, String description) {
		Product product = new Product(name, price, description);
		em.persist(product);
		return product;
	}

	public Product getProduct(Long id) {
		Product product = em.find(Product.class, id);
		return product;
	}
}
