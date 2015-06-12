<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>

<head>
<title>Indirizzo</title>
</head>

<body>
<f:view>
<h:form>
<div>
			<h:outputLabel />Via:
			<h:inputText value="#{addressController.street}"
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
			<h:inputText value="#{addressController.city}"
				required="true"
				requiredMessage="la città è obligatoria"
				id="city">
			</h:inputText>
			<h:message for="city" styleClass="error" />
		</div>
		<div>
			<h:outputLabel />state:
			<h:inputText value="#{addressController.state}"
				required="true"
				requiredMessage="lo stato è obligatorio"
				id="state">
			</h:inputText>
			<h:message for="state" styleClass="error" />
		</div>
		<div>
			<h:outputLabel />zipCode:
			<h:inputText value="#{addressController.zipCode}"
				required="true"
				requiredMessage="lo zipCode è obligatorio"
				validatorMessage="lo zipCode deve essere lunga 5 caratteri"
				id="zipCode">
			<f:validateLength minimum="5" maximum="5" />
			</h:inputText>
			<h:message for="zipCode" styleClass="error" />
		</div>
		<div>
			<h:commandButton value="Submit"	action="#{addressController.createAddress}" />
		</div>
		</h:form>
</f:view>
</body>
</html>