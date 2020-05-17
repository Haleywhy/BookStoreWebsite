<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Book - Evergreen Bookstore Administration</title>
</head>
<body>
   <jsp:include page="/admin/header.jsp" />
   
   <div align="center">
       <h2>Book Management</h2>
       <h3><a href="<%= request.getContextPath() %>/admin/create_book">Create New Book</a></h3>
   </div>
   
   <div align="center">
      <table border="1">
        <tr>
          <th>Index</th>
          <th>ID</th>
          <th>Image</th>
          <th>Title</th>
          <th>Author</th>
          <th>Category</th>
          <th>Price</th>
          <th>Last Updated</th>
          <th>Actions</th>
        </tr>
        <c:forEach items="${books}" var="book" varStatus="status">
        <tr>
          <td>${status.index + 1}</td>
          <td>${book.bookId}</td>
          <td>
             <img src="data:image/jpg;base64,${book.base64Image}" />
          </td>
          <td>${book.title}</td>
          <td>${book.author}</td>
          <td>${book.category.name}</td>
          <td>${book.price}</td>
          <td>${book.lastUpdateTime}</td>
          <td>
            <a href="<%=request.getContextPath() %>/admin/update_book?id=${book.bookId}">Edit</a> &nbsp;
            <a href="<%=request.getContextPath() %>/admin/delete_book?id=${book.bookId}" 
               onclick="if(!confirm('Are you sure to delete the user?')) return false" >Delete</a> 
          </td>
        </tr>
        </c:forEach>
      </table>  
   </div>
   
   <jsp:include page="/admin/footer.jsp" />
</body>
</html>