<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><s:text name="loginPage" /></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script>
	    function test(aa){
	        var targetForm = document.forms[0];	        
	        targetForm.action = "regist.action";
	    }
	    
	    function testooo(aa){
	    alert(aa);
	        var targetForm = document.forms[0];
	        targetForm.action = "newlogin!regist";	        
	    }	    
	</script>
	
  </head>
  
  <body>
  	<s:form action="valid">
  		<s:textfield name="username"  key="user"></s:textfield>
  		<s:textfield name="password" key="pass"></s:textfield>
  		<s:submit key="login" />
  		<s:submit onclick="testooo(1)" value="Regist"></s:submit>
  	</s:form>
  </body>
</html>
