package School_Mangement;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class VeiwStudent extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("malviya");
	EntityManager em=emf.createEntityManager();
	
	 Scanner sc=new Scanner(System.in);
	 int id=  Integer.parseInt(req.getParameter("id")); 
	 Query q=em.createQuery("select z from student z ");
		List<Student>b=q.getResultList();//b=refences
		
	 
	
}
}
