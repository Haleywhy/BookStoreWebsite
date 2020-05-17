<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New User</title>
</head>
<body>
    <jsp:include page="/admin/header.jsp" />
    
    <div align="center">
         <c:if test="${user == null}">
              <h2>Create New User</h2>
         </c:if>
         <c:if test="${user != null}">
              <h2>Edit User</h2>
         </c:if>       
    </div>
    
    <div align="center">
         <c:if test="${user == null}">
         <form action="<%= request.getContextPath() %>/admin/create_user" method="post" onsubmit = "return validateFormInput()">
         </c:if>
         <c:if test="${user != null}">
         <form action="<%= request.getContextPath() %>/admin/update_user?id=${user.userId}" method="post" onsubmit = "return validateFormInput()">
         </c:if>
            <table>
               <tr>
                 <td align="right">Email:</td>
                 <td><input type="text" id="email" name="email" size="20" value="${user.email}"/></td>
               </tr>
               <tr>
                 <td align="right">Full Name:</td>
                 <td><input type="text" id="fullname" name="fullname" size="20" value="${user.fullName}"/></td>
               </tr>
               <tr>
                 <td align="right">Password:</td>
                 <td><input type="password" id="password" name="password" size="20" value="${user.password}"/></td>
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
<script type="text/javascript">
   function validateFormInput(){
	   var fieldEmail = document.getElementById("email");
	   var fieldFullname = document.getElementById("fullname");
	   var fieldPassword = document.getElementById("password");
	   if(fieldEmail.value.length == 0){
		   alert("Email is required!");
		   fieldEmail.focus();
		   return false;
	   }
	   if(fieldFullname.value.length == 0){
		   alert("Name is required!");
		   fieldEmail.focus();
		   return false;
	   }
	   if(fieldPassword.value.length == 0){
		   alert("Password is required!");
		   fieldEmail.focus();
		   return false;
	   }
	   return true;
   }
</script>
</html>