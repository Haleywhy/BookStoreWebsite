<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New Category</title>
</head>
<body>
<jsp:include page="/admin/header.jsp" />
    
    <div align="center">
         <c:if test="${category == null}">
              <h2>Create New Category</h2>
         </c:if>
         <c:if test="${category != null}">
              <h2>Edit Category</h2>
         </c:if>       
    </div>
    
    <div align="center">
         <c:if test="${category == null}">
         <form action="<%= request.getContextPath() %>/admin/create_category" method="post">
         </c:if>
         <c:if test="${category != null}">
         <form action="<%= request.getContextPath() %>/admin/update_category?id=${category.categoryId}" method="post">
         </c:if>
            <table>
               <tr>
                 <td align="right">Category Name:</td>
                 <td><input type="text" id="name" name="name" size="20" value="${category.name}" required/></td>
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