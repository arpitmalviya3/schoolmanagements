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
@WebServlet("/addstudent")
public class AddStudent extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	Student student =new Student();
	student.setId(Integer.parseInt(req.getParameter("id")));
	student.setName(req.getParameter("name"));
	student.setStream(req.getParameter("stream"));
	student.setFees(Double.parseDouble(req.getParameter("fees")));
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("malviya");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	et.begin();
	em.persist(student);
	et.commit();
	
	PrintWriter w= resp.getWriter();
	w.write("Student Add Sucesfully Done...");
	RequestDispatcher rd=req.getRequestDispatcher("Final.html");
	rd.include(req, resp);
	resp.setContentType("text/html");
}
}
