<%@ page import="java.sql.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Todo.TodoDao"%>
<%@ page import="Todo.TodoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
	<button onclick="location='todoAdd.jsp'">할일 등록하기</button>
	<%
		request.setCharacterEncoding("utf-8");

		TodoDao dao = TodoDao.getInstance();
		List<TodoDto> list = new ArrayList<TodoDto>();
		list = dao.selectTodo();
	%>
	<table>
		<tbody>
			<tr>
				<td width="33%">
					<table>
						<tbody>
							<tr>
								<th>TODO</th>
							</tr>
							<%
								for (int i = 0; i < list.size(); i++) {
									TodoDto dto = list.get(i);
									if (dto.getType().equals("TODO")) {
							%>
							<tr>
								<td>
									<form action="UpdateServlet" method="post">
										<div style="border: 1px solid; margin: 5px; padding: 5px">
											<%=dto.getTitle()%><br>
											<%=dto.getRegDate() + ", " + dto.getName() + ", 우선순위 : " + dto.getSequence()%>
											<input type="hidden" name="id" value=<%=dto.getId()%>>
											<input type="hidden" name="regDate" value=<%=dto.getRegDate()%>> 
											<input type="hidden" name="sequence" value=<%=dto.getSequence()%>> 
											<input type="hidden" name="title" value=<%=dto.getTitle()%>>
											<input type="hidden" name="type" value=<%=dto.getType()%>>
											<input type="hidden" name="name" value=<%=dto.getName()%>>
											<input type="submit" value="ㅡ>">
										</div>
									</form>
								</td>
							</tr>
							<%
								}
								}
							%>
						</tbody>
					</table>
				</td>
				<td width="33%">
					<table>
						<tbody>
							<tr>
								<th>DOING</th>
							</tr>
							<%
								for (int i = 0; i < list.size(); i++) {
									TodoDto dto = list.get(i);
									if (dto.getType().equals("DOING")) {
							%>
							<tr>
								<td>
									<form action="UpdateServlet" method="post">
										<div style="border: 1px solid; margin: 5px; padding: 5px">
											<%=dto.getTitle()%><br>
											<%=dto.getRegDate() + ", " + dto.getName() + ", 우선순위 : " + dto.getSequence()%>
											<input type="hidden" name="id" value=<%=dto.getId()%>>
											<input type="hidden" name="regDate" value=<%=dto.getRegDate()%>> 
											<input type="hidden" name="sequence" value=<%=dto.getSequence()%>> 
											<input type="hidden" name="title" value=<%=dto.getTitle()%>>
											<input type="hidden" name="type" value=<%=dto.getType()%>>
											<input type="hidden" name="name" value=<%=dto.getName()%>>
											<input type="submit" value="ㅡ>">
										</div>
									</form>
								</td>
							</tr>
							<%
								}
								}
							%>
						</tbody>
					</table>
				</td>
				<td width="33%">
					<table>
						<tbody>
							<tr>
								<th>DONE</th>
							</tr>
							<%
								for (int i = 0; i < list.size(); i++) {
									TodoDto dto = list.get(i);
									if (dto.getType().equals("DONE")) {
							%>
							<tr>
								<td>
									<div style="border: 1px solid; margin: 5px; padding: 5px">
										<%=dto.getTitle()%><br>
										<%=dto.getRegDate() + ", " + dto.getName() + ", 우선순위 : " + dto.getSequence()%>
									</div>
								</td>
							</tr>
							<%
								}
								}
							%>

						</tbody>
					</table>
				</td>
			</tr>
		</tbody>
	</table>

</body>
</html>