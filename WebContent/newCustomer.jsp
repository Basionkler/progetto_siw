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
    		<h:outputLabel />Name:
	    	<h:inputText value="#{customerController.firstName}"
    			required="true"
				requiredMessage="Il nome è obligatorio" id="firstname">
			</h:inputText>
			<h:message for="name" styleClass="error" />
		</div>
		<div>
    		<h:outputLabel />Cognome:
    		<h:inputText value="#{customerController.lastName}"
    			required="true"
				requiredMessage="Il cognome è obligatorio" id="lastname">
			</h:inputText>
			<h:message for="lastname" styleClass="error" />
		</div>
		<div>
 			<h:outputLabel />Email
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
 			<h:outputLabel />Password:
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
		<h:outputLabel />Data di Nascita:
		<h:inputText value = "#{customerController.dateOfBirth}"
				required = "true"
				requiredMessage="la data di nascita è obbligatoria"
				id="dateOfBirth">
				<f:convertDateTime pattern="dd-MM-yyyy"/>
				<h:message for="dateOfBirth" styleClass="error" />
		</h:inputText>
		</div>
		<div>
			<h:outputLabel />Via:
			<h:inputText value="#{customerController.address.street}"
				required="true"
				requiredMessage="la via è obligatoria"
				validatorMessage="la via deve essere lunga almeno 6 caratteri"
				id="street">
			<f:validateLength minimum="6" maximum="100" />
			</h:inputText>
			<h:message for="street" styleClass="error" />
		</div>
		<div>
			<h:outputLabel />city:
			<h:inputText value="#{customerController.address.city}"
				required="true"
				requiredMessage="la città è obligatoria"
				id="city">
			</h:inputText>
			<h:message for="city" styleClass="error" />
		</div>
		<div>
			<h:outputLabel />state:
			<h:inputText value="#{customerController.address.state}"
				required="true"
				requiredMessage="lo stato è obligatorio"
				id="state">
			</h:inputText>
			<h:message for="state" styleClass="error" />
		</div>
		<div>
			<h:outputLabel />zipCode:
			<h:inputText value="#{customerController.address.zipCode}"
				required="true"
				requiredMessage="lo zipCode è obligatorio"
				validatorMessage="lo zipCode deve essere lunga 5 caratteri"
				id="zipCode">
			<f:validateLength minimum="5" maximum="5" />
			</h:inputText>
			<h:message for="zipCode" styleClass="error" />
		</div>
		<div>
			<h:commandButton value="Submit"	action="#{customerController.createCustomer}" />
		</div>
	</h:form>
</f:view>
</body>
</html>