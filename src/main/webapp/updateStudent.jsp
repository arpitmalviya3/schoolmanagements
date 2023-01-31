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
		<h2 class="bg-danger text-light card-header">Student Detail</h2>

		<%
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("malviya");
		EntityManager em = emf.createEntityManager();
		Student s = em.find(Student.class, id1);
		%>
		<table class="table table-hover table-striped">

			<form action="updatetStudent" method="post">
			<tr>
				<td>Student Id</td>
				<td><input type="text" value="<%=s.getId()%>" name="id"></td>
			</tr>

			<tr>
				<td>Student Name</td>
				<td><input type="text" value="<%=s.getName()%>" name="name"></td>
			</tr>
			<tr>
				<td>Student Stream</td>
				<td><input type="text" value="<%=s.getStream()%>" name="stream"></td>
			</tr>
			<tr>
				<td>Student Fees</td>
				<td><input type="text" value="<%=s.getFees()%>" name="fees"></td>
			</tr>
			<tr>
				<td><button type="submit" class="btn btn-outline-success">Submit</button></td>
				<td><button type="rest" class="btn btn-outline-danger">Reset</button></td>
			</tr>
			</form>
		</table>
</body>
</html>