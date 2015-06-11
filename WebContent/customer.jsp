<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Cliente</title>
	</head>
	<body>
		<f:view>
			<h1>${customerController.customer.firstName}</h1>
			<h1>${customerController.customer.lastName}</h1>
			<h1>${customerController.customer.email}</h1>
			<h2>Details</h2>
			<div>Data di Nascita: ${customerController.customer.dateOfBirth}</div>
			<div>Data di Registrazione: ${customerController.customer.registrationDate}</div>
		</f:view>
	</body>
</html>