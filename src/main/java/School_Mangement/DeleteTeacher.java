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
@WebServlet("/deleteTeacher")
public class DeleteTeacher  extends HttpServlet 
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	EntityManagerFactory emf =Persistence.createEntityManagerFactory("malviya");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();

	 int id=  Integer.parseInt(req.getParameter("id")); 
	 Teacher t=em.find(Teacher.class,id);
	 
		
	 if(t!=null)	
	 {
	 	et.begin();
	 	em.remove(t);
	 	et.commit();
	 	
	 	PrintWriter s= resp.getWriter();
	  	s.write("Delete Sucessfully....");
	 	RequestDispatcher rd=req.getRequestDispatcher("Final.html");
	 	rd.include(req, resp);
		resp.setContentType("text/html");

		 
	 	
	 }
	 else
	 {
		  	PrintWriter r= resp.getWriter();
		  	r.write("*********Invalid id***********");
			RequestDispatcher rd=req.getRequestDispatcher("deleteTeacher.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
	 	
	 }
	 	  
}
}
