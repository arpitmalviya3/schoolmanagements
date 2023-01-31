<%@page import="School_Mangement.Teacher"%>
<%@page import="School_Mangement.Student"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div>
		<h2 class="bg-danger text-light card-header">Teacher Detail</h2>

		<%
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("malviya");
		EntityManager em = emf.createEntityManager();
		Teacher t =em.find(Teacher.class,id1);
		%>
		<table class="table table-hover table-striped">

			<form action="updateTeacher" method="post">
			<tr>
				<td>Teacher Id</td>
				<td><input type="text" value="<%=t.getId()%>" name="id"></td>
			</tr>

			<tr>
				<td>Teacher Name</td>
				<td><input type="text" value="<%=t.getName()%>" name="name"></td>
			</tr>
			<tr>
				<td>Teacher Subject</td>
				<td><input type="text" value="<%=t.getSubject() %>" name="subject"></td>
			</tr>
			<tr>
				<td>Teacher</td>
				<td><input type="text" value="<%=t.getSalary()%>" name="salary"></td>
			</tr>
			<tr>
				<td><button type="submit" class="btn btn-outline-success">Submit</button></td>
				<td><button type="rest" class="btn btn-outline-danger">Reset</button></td>
			</tr>
			</form>
		</table>
</body>
</html>