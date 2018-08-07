//JQuery的入口  
$(function() {  
    loadTable();
 });

function loadTable(){
	$("#dg").datagrid({  
		width : 700,  
		height : 250,  
		iconCls : 'icon-help', // 表格左上角的图标样式  
		url : 'userAction!LoadUserTable', // 访问服务器的地址，要求返回JSON对象  
		rownumbers : true, // 在最前面显示行号  
		fitColumns : true, // 自动适应列宽  
		pagination : true, // 在底部显示分页工具栏  
		striped : true, // 隔行变色  
		singleSelect : true, // 每次只选中一行  
		loadMsg : 'Loading users......',  
		pageSize : 5, // 指定每页的大小，服务器要加上page属性和total属性  
		remoteSort : true, // 从服务器端排序，默认true  
		pageList : [ 3, 5, 10 ], // 可以设置每页记录条数的列表，服务器要加上rows属性  
		idField : 'id', // 主键属性  
	   
		toolbar : [ {// 工具栏  
			 text : 'New User',  
			 iconCls : 'icon-add', // 图标  
			 handler : function() { // 处理函数  
				 newUser();  
			 }  
		 }, {  
			 text : 'Remove User',  
			 iconCls : 'icon-cancel', // 图标  
			 handler : function() { // 处理函数  
				 destroyUser();  
			 }  
		 }, {  
			 text : 'Edit User',  
			 iconCls : 'icon-edit',// 图标  
			 handler : function() {// 处理函数  
				 editUser();  
				 }  
			 } ],  
	   
		columns : [ [ {  
			 field : 'firstName',  
			 title : 'First Name',  
			 width : 80,
			 // 可以排序，但服务器也完成相应的代码，要加入sort和order属性  
			 sortable : true  
		}, {  
			 field : 'lastName',  
			 title : 'Last Name',  
			 //align : 'right',  
			 sortable : true,  
			 width : 80
		}, {  
			 field : 'phone',  
			 title : 'Phone',  
			 sortable : true,
			 width : 80
		}, {  
			 field : 'email',  
			 title : 'Email',  
			 sortable : true
		}]]  
	 }); 
}


function newUser(){
	$('#dlg').dialog('open').dialog('setTitle','New User');
	$('#fm').form('clear');
	//url = 'save_user.php';
}
function editUser(){
	var row = $('#dg').datagrid('getSelected');
	//console.log(row);
	if (row){
		//url = 'userAction!EditUser?UserID='+row.ID;
		$('#dlg').dialog('open').dialog('setTitle','Edit User');
		$("#id").val(row.ID);
		$("#firstname").textbox('setValue',row.firstName);
		$("#lastname").textbox('setValue',row.lastName);
		$("#phone").textbox('setValue',row.phone);
		$("#email").textbox('setValue',row.email);
		//$('#fm').form('load',row);				
	}
}
function saveUser(){
	$('#fm').form('submit',{
		url: 'userAction!SaveUser',
		onSubmit: function(){
			return $(this).form('validate');
		},
		success: function(result){														
			var result = eval('('+result+')');										
			if (result.errorMsg){
				$.messager.show({
					title: 'Error',
					msg: result.errorMsg
				});
			} else {
				$('#dlg').dialog('close');		// close the dialog
				$('#dg').datagrid('reload');	// reload the user data
			}
		}
	});
}
function destroyUser(){
	var row = $('#dg').datagrid('getSelected');
	if (row){
		$.messager.confirm('Confirm','Are you sure you want to destroy this user?',function(r){
			if (r){
				$.post('userAction!DeleteUser',{UserID:row.ID},function(result){
					if (result.success){
						$('#dg').datagrid('reload');	// reload the user data
					} else {
						$.messager.show({	// show error message
							title: 'Error',
							msg: result.errorMsg
						});
					}
				},'json');
			}
		});
	}
}