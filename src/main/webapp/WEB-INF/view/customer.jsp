<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ include file="./common/commonvar.jspf"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户列表页</title>
<link rel="stylesheet" href="${ctx}/asset/base/base.css">
<link rel="stylesheet" href="${ctx}/asset/customer/customer.css">
</head>
<body>
	<h1>客户列表页面</h1>
	<span class="save">添加</span>
	<table>
		<tr>
			<td>名字</td>
			<td>联系人</td>
			<td>手机号</td>
			<td>邮箱</td>
			<td>评论</td>
			<td>操作</td>
		</tr>
		
		<c:forEach items="${customerList}" var="map">
			<tr>
				<td>${map.name}</td>
				<td>${map.contact}</td>
				<td>${map.telephone}</td>
				<td>${map.email}</td>
				<td>${map.remark}</td>
				<td>
					<span class="delete" rid="${map.id}">删除</span>
					<a href="${ctx}/customer_editSubmit?id=${map.id}">修改</a>
				</td>
			</tr>	
		</c:forEach>
		
	</table>
	<script type="text/javascript">
		//添加页面
		$(".save").click(function(){
			location.href = rootPath + "/customer_createSubmit";
		})
		
		//删除方法
		$(".delete").click(function(){
			var id = $(this).attr("rid");
			$.ajax({
				url : rootPath + "/customer_delete",
				type : "get",
				data : {"id" : id},
				dataType : "json",
				success : function(data){
					if (data == true) {
						location.reload();
					}
				}
			})
		})
	</script>
</body>
</html>