<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录成功</title>
</head>
<body>
${currentUser.username }
<h1>success</h1>

<a href="${pageContext.request.contextPath }/logOut"><i class="icon-off"></i> 退出</a><br><br>
	------隔离------	<br><br>				
<shiro:hasRole name="admin">
			<a href="${pageContext.request.contextPath }/toPage"><i class="icon-off"></i>admin有权页面</a><br><br>
</shiro:hasRole>
<%-- 	<shiro:hasPermission name="user:create"> --%>
			<a href="${pageContext.request.contextPath }/tocreate"><i class="icon-off"></i>admin有权create页面</a><br><br>
<%-- 	</shiro:hasPermission> --%>
<%-- 	<shiro:hasPermission name="user:delete"> --%>
			<a href="${pageContext.request.contextPath }/todelete"><i class="icon-off"></i>admin有权delete页面</a><br><br>
<%-- 	</shiro:hasPermission> --%>
</body>
</html>