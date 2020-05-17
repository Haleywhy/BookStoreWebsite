<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Users - Evergreen Bookstore Administration</title>
</head>
<body>
   <jsp:include page="/admin/header.jsp" />
   
   <div align="center">
       <h2>Users Management</h2>
       <h3><a href="<%= request.getContextPath() %>/admin/create_user">Create New User</a></h3>
   </div>
   <c:if test="${message != null}">
      <div align="center">
         <h4><i>${message}</i></h4>
      </div>
   </c:if>
   <div align="center">
      <table border="1">
        <tr>
          <th>Index</th>
          <th>ID</th>
          <th>Email</th>
          <th>Full Name</th>
          <th>Actions</th>
        </tr>
        <c:forEach items="${userList}" var="user" varStatus="status">
        <tr>
          <td>${status.index + 1}</td>
          <td>${user.userId}</td>
          <td>${user.email}</td>
          <td>${user.fullName}</td>
          <td>
            <a href="<%=request.getContextPath() %>/admin/update_user?id=${user.userId}">Edit</a> &nbsp;
            <a href="<%=request.getContextPath() %>/admin/delete_user?id=${user.userId}" 
               onclick="if(!confirm('Are you sure to delete the user?')) return false" >Delete</a> 
          </td>
        </tr>
        </c:forEach>
      </table>  
   </div>
   
   <jsp:include page="/admin/footer.jsp" />

</body>
</html>