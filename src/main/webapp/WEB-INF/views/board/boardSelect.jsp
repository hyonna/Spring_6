<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<h1>${board}Select</h1>
	<table class="table table-hover">
		<tr>
			<td>NO</td><td>TITLE</td><td>WRITER</td><td>DATE</td><td>HIT</td>
		</tr>
		<tr>
			<td>${dto.num}</td><td>${dto.title}</td><td>${dto.writer}</td><td>${dto.reg_date}</td><td>${dto.hit}</td>
		</tr>
		<tr>
			<td colspan="5">${dto.contents}</td>
		</tr>
	</table>
	<div style="float: right;">
		<a href="./${board}Update?num=${dto.num}"><button class="btn btn-primary">Update</button></a>
		<a href="./${board}Delete?num=${dto.num}"><button class="btn btn-danger">Delete</button></a>
	</div>
	<div style="float: left;">
		<a href="./${board}List"><button class="btn btn-default">List</button></a>
	</div>
</div>
</body>
</html>