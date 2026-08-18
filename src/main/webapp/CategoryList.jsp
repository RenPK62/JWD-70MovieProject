<%@page import="java.util.List"%>
<%@page import="model.CategoryBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Category List</h3>

<%-- <%

List <CategoryBean> catList = (List<CategoryBean>) request.getAttribute("catList");

for(CategoryBean obj:catList) {
	%>
	
	<a href = "MovieListServlet?catId=<%= obj.getId() %>"> <%= obj.getType() %> </a>
	
<%
}
%> --%>
 
<c:forEach items="${catList}" var="category">

<a href = "MovieListServlet?catId=${category.id}"> ${category.type}</a>
</c:forEach>

</body>
</html>