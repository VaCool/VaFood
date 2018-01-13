package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import MySQL.ToGetReviewsMySQL;

@WebServlet(urlPatterns = {"/reviews"})
public class ToGetReviewsServlet extends HttpServlet{
	  private static final long serialVersionUID = 1L;
	  @Override
	  public void doGet(HttpServletRequest req, HttpServletResponse res)
			 throws ServletException, IOException {		


		  	 ToGetReviewsMySQL sql = new ToGetReviewsMySQL();
			 JSONArray obj = new JSONArray();	
			 System.out.println("hi");
			 try {
				 obj = sql.SQL();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 System.out.println(obj);
			   res.setCharacterEncoding("UTF-8");
			   res.setContentType("application/json");
			   PrintWriter out = res.getWriter();
			   out.print(obj);

	}
}
