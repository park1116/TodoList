<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add Todo</title>
</head>
<body>
	<h1>할일 등록</h1>
	<form action="InsertServlet" method="post">
		<div class="section">
			<span>어떤일인가요?</span><br> 
			<input type="text" name="what">
		</div>
		<div class="section">
			<span>누가 할일인가요?</span><br> 
			<input type="text" name="who">
		</div>
		<div class="section">
			<span>우선순위를 선택하세요</span><br> 
			<input type="radio" name="rank" value="1" /> 1순위 
			<input type="radio" name="rank" value="2" /> 2순위 
			<input type="radio" name="rank" value="3" /> 3순위
		</div>
		<input type="button" onclick="location='index.jsp'" value="이전">
		<input type="submit" class="btnBox" value="제출"> 
		<input type="reset" class="btnBox" value="내용지우기">
	</form>
</body>
</html>