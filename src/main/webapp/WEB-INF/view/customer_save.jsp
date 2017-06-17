<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ include file="./common/commonvar.jspf"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加页面</title>
</head>
<link rel="stylesheet" href="${ctx}/asset/base/base.css">
<style>
	td{
		display : block;
	}
	.back,.sure{
		cursor : pointer; 
	}
</style>
<body>
	<h1>客户添加页面</h1>
	<form action="" id="ajaxForm">
		<table>
			<tr>
				<td>名字 : <input type="text" name="name" value=""></td>
				<td>联系人: <input type="text" name="contact" value=""></td>
				<td>手机号: <input type="text" name="telephone" value=""></td>
				<td>邮箱: <input type="text" name="email" value=""></td>
				<td>评论: <input type="text" name="remark" value=""></td>
			</tr>	
		</table>
		<div>
			<span class="back">返回</span>
			<span class="sure">确定</span>
		</div>
	</form>
</body>
	<script type="text/javascript">
	$(".sure").click(function(){
		$.ajax({
			url : rootPath + "/customer_save",
			type : "post",
			data : $("#ajaxForm").serialize(),
			dataType : "json",
			success : function(data){
				if(data == true){
					location.href = "${ctx}/customer";
				}
			}
		});
	})
	$(".back").click(function(){
		window.history.go(-1);
	});
	</script>
</html>