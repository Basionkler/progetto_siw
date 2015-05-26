package it.uniroma3.siw.controller;

import java.io.IOException;

import it.uniroma3.siw.action.Action;
import it.uniroma3.siw.model.facade.ProductFacade;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller/*") 
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB(beanName="pFacade")
	private ProductFacade productFacade;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nextPage = null;
		String actionName = path2action(request);
		Action action;

		try {
			action = (Action)Class.forName(actionName).newInstance();
			nextPage = action.perform(request, productFacade);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String path2action(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
}