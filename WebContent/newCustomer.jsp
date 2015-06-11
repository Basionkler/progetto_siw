<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>

<head>
<title>Registrati</title>
</head>

<body>
<f:view>
	<h:form>
		<div>
    		Name:
	    	<h:inputText value="#{customerController.firstName}"
    			required="true"
				requiredMessage="Il nome è obligatorio" id="firstname">
			</h:inputText>
			<h:message for="name" styleClass="error" />
		</div>
		<div>
    		Cognome:
    		<h:inputText value="#{customerController.lastName}"
    			required="true"
				requiredMessage="Il cognome è obligatorio" id="lastname">
			</h:inputText>
			<h:message for="lastname" styleClass="error" />
		</div>
		<div>
 			email:
    		<h:inputText value="#{customerController.email}"
    			required="true"
				requiredMessage="la mail è obligatoria"
				validatorMessage="Il Codice deve essere lungo tra i 6 e gli 8 caratteri"
				id="email">
				<f:validateLength minimum="6" maximum="10" />
			</h:inputText>
			<h:message for="email" styleClass="error" />
		</div>
		<div>
 			password:
    		<h:inputText value="#{customerController.password}"
    			required="true"
				requiredMessage="la password è obligatoria"
				validatorMessage="la password deve essere lungo almeno 6 caratteri"
				id="password">
				<f:validateLength minimum="6" maximum="100" />
			</h:inputText>
			<h:message for="password" styleClass="error" />
		</div>
		<div>
			<h:commandButton value="Submit"	action="#{customerController.createCustomer}" />
		</div>
	</h:form>
</f:view>
</body>
</html>