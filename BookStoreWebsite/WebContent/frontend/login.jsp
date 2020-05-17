<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log In</title>
</head>
<body>
     <jsp:include page="/frontend/header.jsp"/>
     
     <div align="center"> 
        <h2>Please Login here</h2>
        <form>
           email: <input type="text" size="10"/><br/>
           Password: <input type="password" size="10"/><br/>
           <input type="submit" value="Login"/>
        </form>
     </div>
     
     <jsp:include page="/frontend/footer.jsp"/>
</body>
</html>