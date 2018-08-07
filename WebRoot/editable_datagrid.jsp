<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="keywords" content="jquery,ui,easy,easyui,web">
	<meta name="description" content="easyui help you build your web page easily!">
	<title>Build CRUD DataGrid with jQuery EasyUI - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
	<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.edatagrid.js"></script>
	<script type="text/javascript">
		$(function(){
			$('#dg').edatagrid({
				url: 'userAction!LoadUserTable',
				//saveUrl: 'userAction!SaveUser',
				//updateUrl: 'userAction!SaveUser',
				//destroyUrl: 'userAction!DeleteUser',
				onBeforeSave:function(index){
					console.log(index);
				},
				onDestroy:function(index, row){
					$.post('userAction!DeleteUser',
					{
						"UserID":row.ID
					},function(result){
						console.log(result.success);	
					},'json');
				},
				onSave:function(index, row){
				    console.log(index);
					console.log(row.phone);
					$.post('userAction!SaveUser',
					{
						"user.ID":row.ID,
						"user.firstName":row.firstName,
						"user.lastName":row.lastName,
						"user.phone":row.phone,
						"user.email":row.email
					},function(result){
							
					},'json');
				}
			});
		});
	</script>
</head>
<body>
	<h2>CRUD DataGrid</h2>
	<div class="demo-info" style="margin-bottom:10px">
		<div class="demo-tip icon-tip">&nbsp;</div>
		<div>Double click the row to begin editing.</div>
	</div>
	
	<table id="dg" title="My Users" style="width:700px;height:250px"
			toolbar="#toolbar" pagination="true" idField="ID"
			rownumbers="true" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="firstName" width="50" editor="{type:'validatebox',options:{required:true}}">First Name</th>
				<th field="lastName" width="50" editor="{type:'validatebox',options:{required:true}}">Last Name</th>
				<th field="phone" width="50" editor="text">Phone</th>
				<th field="email" width="50" editor="{type:'validatebox',options:{validType:'email'}}">Email</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:$('#dg').edatagrid('addRow')">New</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="javascript:$('#dg').edatagrid('destroyRow')">Destroy</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="javascript:$('#dg').edatagrid('saveRow')">Save</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="javascript:$('#dg').edatagrid('cancelRow')">Cancel</a>
	</div>
	
</body>
</html>
