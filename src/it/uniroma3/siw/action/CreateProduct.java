package it.uniroma3.siw.action;

import it.uniroma3.siw.model.Product;
import it.uniroma3.siw.model.facade.ProductFacade;

import javax.servlet.http.HttpServletRequest;

public class CreateProduct implements Action {

	public String perform(HttpServletRequest request) {
		
		HelperProduct helper = new HelperProduct();
		
		if (helper.isValid(request)) {
			String name = request.getParameter("name");
			String code = request.getParameter("code");
			Float price = Float.parseFloat(request.getParameter("price"));
			String description = request.getParameter("description");
			
			ProductFacade facade = new ProductFacade();
			Product product = facade.createProduct(name, code, price, description);
			request.setAttribute("product", product);
			
			return "/product.jsp";
		} else
			return "/newProduct.jsp";
	}
}