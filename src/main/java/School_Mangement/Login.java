package School_Mangement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Query;

@WebServlet("/Login")
public class Login  extends HttpServlet
{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	 EntityManagerFactory emf=Persistence.createEntityManagerFactory("malviya");
	 EntityManager em=emf.createEntityManager();
	 
	 String email=req.getParameter("email");
	 String password=req.getParameter("password");

	 
	 javax.persistence.Query q=em.createQuery("select a from Principle a where a.email=?1 and a.password=?2");
	  q.setParameter(1, email);
	  q.setParameter(2, password);
	  
	  List<Principle>l=q.getResultList();
	 // System.out.println(l);
	  if(l.size()>0)
	  {
		  PrintWriter w= resp.getWriter();
			w.write("******Login Sucessfull*******");
		  RequestDispatcher rd=req.getRequestDispatcher("Final.html");
		  rd.include(req, resp);
		  resp.setContentType("text/html");
	  }
	  else
	  {
		  PrintWriter w= resp.getWriter();
			w.write("Invalid data");
			RequestDispatcher rd=req.getRequestDispatcher("Login.html");
			rd.include(req, resp);
			 resp.setContentType("text/html");
	  }
	  }
}


