<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=basePath %>studentUpdate?id=${student.id}" method="post">
             <h4>修改</h4>
             姓名 <input type="text" name="name" value="${student.name}"><br />
             年龄<input    type="text" name="age" value="${student.age}"><br /> 
              性别: <c:if test="${student.sex==1 }">
                   <select name="sex" >
                 <option value="1">男</option>
                 <option value="0">女</option>
                </select> 
         </c:if>
         <c:if test="${student.sex==0 }">
                <select name="sex" >
                   <option value="0">女</option>
                   <option value="1">男</option> 
               </select>
         </c:if>
         <br /> 
            <input type="submit" value="修改"/>
            <hr />
       </form>
</body>
</html>