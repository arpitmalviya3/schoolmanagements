package School_Mangement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
import com.mysql.cj.Query;

@WebServlet("/deletestudent")
public class DeleteStudent extends HttpServlet
{ @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
EntityManagerFactory emf =Persistence.createEntityManagerFactory("malviya");
EntityManager em=emf.createEntityManager();
EntityTransaction et=em.getTransaction();

 int id=  Integer.parseInt(req.getParameter("id")); 
 Student s=em.find(Student.class,id);
 
	
 if(s !=null)	
 {
 	et.begin();
 	em.remove(s);
 	et.commit();
 	PrintWriter w= resp.getWriter();
  	w.write("Delete Sucessfully....");
 	RequestDispatcher rd=req.getRequestDispatcher("Final.html");
 	rd.include(req, resp);
	resp.setContentType("text/html");
	
 	
 }
 else
 {
	  	PrintWriter w= resp.getWriter();
	  	w.write("Invalid id");
		RequestDispatcher rd=req.getRequestDispatcher("deleteStudent.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
 	
 }
 	  
 	  

}
}
