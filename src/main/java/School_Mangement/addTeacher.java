package School_Mangement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/addTeacher")
public class addTeacher extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	Teacher teacher=new Teacher();
	teacher.setId(Integer.parseInt(req.getParameter("id")));
	teacher.setName(req.getParameter("name"));
	teacher.setSubject(req.getParameter("subject"));
	teacher.setSalary(Double.parseDouble(req.getParameter("salary")));
	
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("malviya");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	et.begin();
	em.persist(teacher);
	et.commit();
	
	PrintWriter w= resp.getWriter();
	w.write("Teacher Add Sucesfully Done...");
	RequestDispatcher rd=req.getRequestDispatcher("Final.html");
	rd.include(req, resp);
	resp.setContentType("text/html");
}
}
