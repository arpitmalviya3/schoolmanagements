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

@WebServlet("/create")
public class School_Management extends HttpServlet
{
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	Principle principle=new Principle();
	principle.setName(req.getParameter("names"));
	principle.setAge(Integer.parseInt(req.getParameter("age")));
	principle.setEmail(req.getParameter("email"));
	principle.setPassword(req.getParameter("password"));
	principle.setMobno(Long.parseLong(req.getParameter("mobileno")));
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("malviya");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	
	et.begin();
	em.persist(principle);
	et.commit();
	
	PrintWriter w= resp.getWriter();
	w.write("Account is Created....");
	RequestDispatcher rd=req.getRequestDispatcher("Login.html");
	rd.include(req, resp);
	resp.setContentType("text/html");
	
}
}
