<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Category - Evergreen Bookstore Administration</title>
</head>
<body>
   <jsp:include page="/admin/header.jsp" />
   
   <div align="center">
       <h2>Category Management</h2>
       <h3><a href="<%= request.getContextPath() %>/admin/create_category">Create New Category</a></h3>
   </div>
   
   <div align="center">
      <table border="1">
        <tr>
          <th>Index</th>
          <th>ID</th>
          <th>Name</th>
          <th>Actions</th>
        </tr>
        <c:forEach items="${categories}" var="category" varStatus="status">
        <tr>
          <td>${status.index + 1}</td>
          <td>${category.categoryId}</td>
          <td>${category.name}</td>
          <td>
            <a href="<%=request.getContextPath() %>/admin/update_category?id=${category.categoryId}">Edit</a> &nbsp;
            <a href="<%=request.getContextPath() %>/admin/delete_category?id=${category.categoryId}" 
               onclick="if(!confirm('Are you sure to delete the user?')) return false" >Delete</a> 
          </td>
        </tr>
        </c:forEach>
      </table>  
   </div>
   
   <jsp:include page="/admin/footer.jsp" />

</body>
</html>