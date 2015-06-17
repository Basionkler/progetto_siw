package it.uniroma3.siw.model.facade;

import it.uniroma3.siw.model.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import java.util.List;

@Stateless(name="productFacade")
public class ProductFacade{
	
    @PersistenceContext(unitName = "products-unit")
    private EntityManager em;
    
	public Product createProduct(String name, String code, Float price, String description, Integer quantitaDisponibile) {
		Product product = new Product(name, price, description, code, quantitaDisponibile);
		em.persist(product);
		return product;
	}
	
	public Product getProduct(Long id) {
	    Product product = em.find(Product.class, id);
		return product;
	}
	
	public List<Product> getAllProducts() {
       CriteriaQuery<Product> cq = em.getCriteriaBuilder().createQuery(Product.class);
        cq.select(cq.from(Product.class));
        List<Product> products = em.createQuery(cq).getResultList();
		return products;
	}

	public void updateProduct(Product product) {
        em.merge(product);
	}
	
    public void deleteProduct(Product product) {
        em.remove(product);
    }

	public void deleteProduct(Long id) {
        Product product = em.find(Product.class, id);
        deleteProduct(product);
	}
}
