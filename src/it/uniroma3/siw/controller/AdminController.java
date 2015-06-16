package it.uniroma3.siw.controller;

import it.uniroma3.siw.model.Admin;
import it.uniroma3.siw.model.facade.AdminFacade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="adminController")
@SessionScoped
public class AdminController{
	
	private String nickname;
    private String email;
    private String password;
	
	private Admin admin;

	@EJB(beanName="adminFacade")
	private AdminFacade adminFacade;
	
	public String createAdmin() {
		this.admin = adminFacade.createAdmin(nickname, email, password);
		return "adminProfile";
	}

	public String login() {
		this.admin = adminFacade.getAdminByNickName(this.nickname);
		if(this.admin!=null && adminFacade.controllaPassword(this.admin,this.password)){
			return "adminProfile";
		} else {
			return "error";
		}
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

}
