<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Products</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>Descrição</th>
			<th>Ações</th>
		</tr>
		<tr>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.description}</td>
					<td>
						<a href="<c:url value='/product/remove?id=${product.id}'/>">Remove</a>
					</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
</body>
</html>