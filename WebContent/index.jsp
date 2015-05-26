 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>progetto_siw</title>
</head>
<body>
<h1>progetto_siw</h1>
<ul>
<li><a href="<c:url value="/newProduct.jsp" />">Insert a new product</a></li>
</ul>
${action}
</body>
</html>