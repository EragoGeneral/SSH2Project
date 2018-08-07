<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Basic CRUD Application - jQuery EasyUI CRUD Demo</title>
	<link rel="stylesheet" type="text/css" href="css/easyui.css">
	<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/themes/color.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="script/jquery.min.js"></script>
	<script type="text/javascript" src="script/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="script/datagrid/BaseCRUD.js" charset="GBK"></script>
</head>
<body>
	<h2>Basic CRUD Application</h2>
	<s:property value="results"/>
	<br>
	<s:property value="tips"/>
	<p>Click the buttons on datagrid toolbar to do crud actions.</p>
	
	<table id="dg"></table>
	
	<!-- 
	<table id="dg" title="My Users" class="easyui-datagrid" style="width:700px;height:250px"
			url="userAction!LoadUserTable" idField="ID" 
			toolbar="#toolbar" pagination="true"
			rownumbers="true" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="firstName" width="50">First Name</th>
				<th field="lastName" width="50">Last Name</th>
				<th field="phone" width="50">Phone</th>
				<th field="email" width="50">Email</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">New User</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">Edit User</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">Remove User</a>
	</div>
	 -->
	
	<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
			closed="true" buttons="#dlg-buttons">
		<div class="ftitle">User Information</div>
		<form id="fm" method="post" novalidate>
			<div class="fitem">
				<label>First Name:</label>
				<input type="hidden" id="id" name="user.ID" />
				<input id="firstname" name="user.FirstName" class="easyui-textbox" required="true">
			</div>
			<div class="fitem">
				<label>Last Name:</label>
				<input id="lastname" name="user.LastName" class="easyui-textbox" required="true">
			</div>
			<div class="fitem">
				<label>Phone:</label>
				<input id="phone" name="user.Phone" class="easyui-textbox">
			</div>
			<div class="fitem">
				<label>Email:</label>
				<input id="email" name="user.Email" class="easyui-textbox" validType="email">
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">Save</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
	</div>
	<style type="text/css">
		#fm{
			margin:0;
			padding:10px 30px;
		}
		.ftitle{
			font-size:14px;
			font-weight:bold;
			padding:5px 0;
			margin-bottom:10px;
			border-bottom:1px solid #ccc;
		}
		.fitem{
			margin-bottom:5px;
		}
		.fitem label{
			display:inline-block;
			width:80px;
		}
		.fitem input{
			width:160px;
		}
	</style>
</body>
</html>