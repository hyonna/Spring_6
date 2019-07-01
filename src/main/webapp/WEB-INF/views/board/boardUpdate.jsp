<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1>${board}Update</h1>
	<br>
	<form action="./${board}Update" method="post">
		<input type="hidden" name="num" value="${dto.num}">
		<div class="form-group">
		  <label for="title">Title:</label>
 		 <input class="form-control" type="text" id="title" name="title" value="${dto.title}">
		</div>
		<div class="form-group">
		  <label for="writer">Writer:</label>
 		 <input class="form-control" type="text" id="writer" name="writer" value="${dto.writer}">
		</div>
		<div class="form-group">
		  <label for="contents">Contents:</label>
 		 <textarea class="form-control" rows="5" id="contents" name="contents">${dto.contents}</textarea>
		</div>
		<div class="form-group">
			<input type="file" name="f1">
			<input type="file" name="f1">
		</div>
		<div>
			<button class="btn btn-primary">Update</button>
		</div>
	</form>
</div>
</body>
</html>