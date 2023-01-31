<%@page import="javax.persistence.Query"%>
<%@page import="java.util.List"%>
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
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("malviya");
		EntityManager em = emf.createEntityManager();
		%>
		
		<%
		Query q=em.createQuery("select a from Teacher a");
		%>
		
		<%List<Teacher> ls = q.getResultList(); %>
		<table class="table table-hover table-striped">
         
         <th>Teacher Id</th>
			 <th>Teacher Name</th>
			  <th>Teacher Subject</th>
			   <th>Teacher Salary</th>

			<%
			for(Teacher t : ls){
			%>
			<tr>
			<td><%= t.getId()%></td>
			<td><%=t.getName() %></td>
			<td><%=t.getSubject() %></td>
			<td><%=t.getSalary()%></td>
			
			
			
			
			</tr>
			</form>
			<%
			}
			%>
		</table>
</body>
</html>