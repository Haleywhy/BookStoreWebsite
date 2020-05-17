<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Create New Book</title>
   <script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
   <script type="text/javascript" src="../js/jquery.validate.min.js"></script>
   <script type="text/javascript" src="../js/jquery-ui.min.js"></script>
   <script type="text/javascript" src="../js/jquery.richtext.min.js"></script>
</head>
<body>
  <jsp:include page="/admin/header.jsp" />
    
    <div align="center">
         <c:if test="${book == null}">
              <h2>Create New Book</h2>
         </c:if>
         <c:if test="${book != null}">
              <h2>Edit Book</h2>
         </c:if>       
    </div>
    
    <div align="center">
         <c:if test="${book == null}">
         <form action="<%= request.getContextPath() %>/admin/create_book" method="post">
         </c:if>
         <c:if test="${category != null}">
         <form action="<%= request.getContextPath() %>/admin/update_book?id=${book.bookId}" method="post">
         </c:if>
            <table>
               <tr>
                 <td align="right">Category:</td>
                 <td>
                   <select name="category">
                     <c:forEach items="${categoryList}" var="category">
                          <option value="${category.categoryId}">${category.name}</option>      
                     </c:forEach>
                   </select>
                 </td>
               </tr>
               <tr>
                 <td align="right">Title:</td>
                 <td><input type="text" id="title" name="title" size="20" value="${book.title}" required /></td>
               </tr>
               <tr>
                 <td align="right">Author:</td>
                 <td><input type="text" id="author" name="author" size="20" value="${book.author}" required /></td>
               </tr>
               <tr>
                 <td align="right">ISBN:</td>
                 <td><input type="text" id="isbn" name="isdn" size="20" value="${book.isbn}" required /></td>
               </tr>
               <tr>
                 <td align="right">Publish Date:</td>
                 <td><input type="text" id="publishDate" name="publishDate" size="20" value="${book.publishDate}" required /></td>
               </tr>
               <tr>
                 <td align="right">Book Image:</td>
                 <td><input type="file" id="image" name="image" size="20" required /></td>
               </tr>
               <tr>
                 <td align="right">Price:</td>
                 <td><input type="text" id="price" name="price" size="20" value="${book.price}" required /></td>
               </tr>
               <tr>
                 <td align="right">Description:</td>
                 <td>
                   <textarea rows="5" cols="50" name="description" required></textarea>
                 </td>
               </tr>
               <tr><td>&nbsp;</td></tr>
               <tr>
                 <td colspan="2" align="center">
                   <input type="submit" value="Save" />
                   <input type="button" value="Cancel" onclick="javascript:history.go(-1);" /> 
                 </td>
               </tr>
            </table>
         </form>
    </div>
    
    <jsp:include page="/admin/footer.jsp" />
</body>
</html>