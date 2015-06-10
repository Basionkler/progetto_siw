
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<title>New Product</title>
</head>
<body>
<f:view>
<h:form>
    <div>Name: <h:inputText value="#{productController.name}"
    	required = "true"
    	requiredMessage="Il nome è obligatorio" id="name"/> <strong><h:message for="name" /></strong>
    </div>
    <div>Code: <h:inputText value="#{productController.code}"
    	required = "true"
    	requiredMessage="Il Codice è obligatorio" id="code"/> <strong><h:message for="code" /></strong>
    </div>
	<div>Price: <h:inputText value="#{productController.price}"
		required = "true"
    	requiredMessage="Il prezzo è obligatorio"
    	converterMessage="Il prezzo deve essere un numero" id="price"/> id="price"/> <strong><h:message for="price" /></strong>
	</div>
	<div>Description: <h:inputText value="#{productController.description}"
		required="false" 
    	cols="20" rows="5" /> 
	</div>
    <div><h:commandButton value="Submit"  action="#{productController.createProduct}"/></div>
</h:form>
</f:view>
</body>
</html>