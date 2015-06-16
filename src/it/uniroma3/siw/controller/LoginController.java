package it.uniroma3.siw.controller;

import it.uniroma3.siw.model.Admin;
import it.uniroma3.siw.model.Customer;
import it.uniroma3.siw.model.facade.AdminFacade;
import it.uniroma3.siw.model.facade.CustomerFacade;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="loginController")
@RequestScoped
public class LoginController {

	protected String email;
	protected String password;

	private Customer customer;
	private Admin admin;


	@ManagedProperty("#{adminController}")
	AdminController aController;

	@ManagedProperty("#{customerController}")
	CustomerController cController;

	@EJB(beanName="adminFacade")
	private AdminFacade adminFacade;

	@EJB(beanName="customerFacade")
	private CustomerFacade customerFacade;

	@PostConstruct
	public void init() {
	ELContext elContext = FacesContext.getCurrentInstance().getELContext();
	aController = (AdminController)FacesContext.getCurrentInstance().getApplication()
			.getELResolver().getValue(elContext, null, "aController");
	cController = (CustomerController)FacesContext.getCurrentInstance().getApplication()
			.getELResolver().getValue(elContext, null, "cController");
	}
	
	public String adminLogin() {
		this.admin = adminFacade.getAdminByEmail(this.email);
		if(this.admin!=null && adminFacade.controllaPassword(this.admin,this.password)){
			aController.setAdmin(this.admin);
			return "adminProfile";
		} else {
			return "error";
		}
	}

	public String userLogin() {
		this.customer = customerFacade.getCustomer(this.email);
		if(this.customer!=null && customerFacade.controllaPassword(this.customer,this.password)){
			cController.setCustomer(this.customer);
			return "customerProfile";
		} else {
			return "error";
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public AdminFacade getAdminFacade() {
		return adminFacade;
	}

	public void setAdminFacade(AdminFacade adminFacade) {
		this.adminFacade = adminFacade;
	}

	public CustomerFacade getCustomerFacade() {
		return customerFacade;
	}

	public void setCustomerFacade(CustomerFacade customerFacade) {
		this.customerFacade = customerFacade;
	}

	public AdminController getaController() {
		return aController;
	}

	public void setaController(AdminController aController) {
		this.aController = aController;
	}

	public CustomerController getcController() {
		return cController;
	}

	public void setcController(CustomerController cController) {
		this.cController = cController;
	}

}
