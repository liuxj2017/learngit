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
<title>主页</title>
</head>
<body>
<h2>欢迎</h2>

  <div align="center"style="width: 400px;">
  		<form action="<%=basePath %>studentAdd" method="post">
             <h4>新增用户</h4>
             姓名 <input type="text" name="name"><br />
             年龄<input    type="text" name="age"><br /> 
              性别: <select name="sex">
                 <option value="1">男</option>
                 <option value="0">女</option>
             </select><br /> 
            <input type="submit" value="新增"/>
            <hr />
         </form>
        <form action="<%=basePath%>queryAllStudent" method="post">
        <input type="submit" value="查看所有的数据"></input>
             <table border="1"  > 
                  <thead>
                   <tr><td>ID</td><td>姓名</td><td>年龄</td><td>性别</td><td>操作</td></tr>
                  </thead>
                  <tbody>
          <c:forEach items="${list}" var="list">
          <tr>
                 <td>${list.id }</td>
                 <td>${list.name }</td>
                 <td>${list.age }</td>
                 <td><c:if test="${list.sex==1 }">男</c:if>
                 <c:if test="${list.sex==0 }">女</c:if></td>
           <td><a  href= "<%=basePath%>findStudentById?id=${list.id}"     style='text-decoration:none'  >修改&nbsp;</a> 
             <a    href= "<%=basePath%>studentDel?id=${list.id}"   style='text-decoration:none'     >删除</a>  </td> 
          </tr>
          </c:forEach>
                  </tbody>
             </table>
             <hr />
        </form>
     </div> 


</body>
</html>