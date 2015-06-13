package it.uniroma3.siw.model.facade;

import java.util.List;

import it.uniroma3.siw.model.Address;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class AddressFacade {
	
	 @PersistenceContext(unitName = "aFacade")
	 private EntityManager em;

	 public Address createAddress(String street, String city, String state, String zipCode, String country){
		 Address a = new Address(street, city, state, zipCode, country);
		return a;
	 }
	 
		public Address getAddress(Long id) {
			Address address = em.find(Address.class, id);
			return address;
		}
		
		public List<Address> getAllAddress() {
	        CriteriaQuery<Address> cq = em.getCriteriaBuilder().createQuery(Address.class);
	        cq.select(cq.from(Address.class));
	        List<Address> addresses = em.createQuery(cq).getResultList();
			return addresses;
		}

		public void updateAddress(Address address) {
	        em.merge(address);
		}
		
	    private void deleteAddress(Address address) {
	        em.remove(address);
	    }

		public void deleteAddress(Long id) {
	        Address address = em.find(Address.class, id);
	        deleteAddress(address);
		}
}
