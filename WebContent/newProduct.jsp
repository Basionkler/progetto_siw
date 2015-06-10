<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>

<head>
<title>New Product</title>
</head>

<body>
	<f:view>
		<h:form>
    Name:
    	<h:inputText value="#{productController.name}" required="true"
				requiredMessage="Il nome è obligatorio" id="name">
			</h:inputText>
			<h:message for="name" styleClass="error" />

    Code:
    	<h:inputText value="#{productController.code}" required="true"
				requiredMessage="Il Codice è obligatorio"
				validatorMessage="Il Codice deve essere lungo tra i 6 e gli 8 caratteri"
				id="code">
				<f:validateLength minimum="6" maximum="10" />
			</h:inputText>
			<h:message for="code" styleClass="error" />

	Price:
		<h:inputText value="#{productController.price}" required="true"
				requiredMessage="Il prezzo è obligatorio"
				converterMessage="Il prezzo deve essere un numero"
				validatorMessage="il prezzo deve essere maggiore di zero" id="price">
				<f:validateDoubleRange minimum="0" />
			</h:inputText>
			<h:message for="code" styleClass="error" />

	Description:
		<h:inputText value="#{productController.description}" required="false">
			</h:inputText>
			<h:commandButton value="Submit"
				action="#{productController.createProduct}" />

		</h:form>
	</f:view>
</body>
</html>