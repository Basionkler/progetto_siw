
<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
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
    <div>Name: <h:inputText value="#{productController.name}"/></div>
    <div>Code: <h:inputText value="#{productController.code}"/></div>
	<div>Price: <h:inputText value="#{productController.price}"/></div>
	<div>Description: <h:inputText value="#{productController.description}"/></div>
    <div><h:commandButton value="Submit"  action="#{productController.createProduct}"/></div>
</h:form>
</f:view>
</body>
</html>