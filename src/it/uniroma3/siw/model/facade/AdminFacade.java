//package it.uniroma3.siw.model.facade;
//
//import it.uniroma3.siw.abstr.User;
//import it.uniroma3.siw.model.Admin;
//import it.uniroma3.siw.model.Customer;
//import it.uniroma3.siw.model.ProductCatalogue;
//
//import java.util.Date;
//import java.util.List;
//
//import javax.ejb.Stateless;
//import javax.persistence.*;
//
//public class AdminFacade {
//	
//	@Stateless(name = "aFacade")
//	public class UserFacade {
//		
//		@PersistenceContext(unitName = "adminFacade")
//		private EntityManager em;
//		
//		public User createUser(Long id, String firstName, String lastName, String email, String password,
//				Date dateOfBirth, Date registrationDate,List<Customer> customerRegistry, ProductCatalogue currentCatalogue) {
//			User a = new Admin(id, firstName, lastName, email, password, dateOfBirth, registrationDate, customerRegistry, currentCatalogue);
//			em.persist(a);
//			return null;
//		}
//		
//		public Admin getUser(Long id) {
//			Admin user = em.find(Admin.class, id);
//			return user;
//		}
//
//	}
//}
