package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MySQL.VerificationMySQL;

@WebServlet(urlPatterns = {"/verification"})
public class VerificationServlet extends HttpServlet{
	  public void doPost(HttpServletRequest req, HttpServletResponse res)
			  throws ServletException, IOException {
		  
		  String verification =  req.getParameter("verification");
		  String client_id =  req.getParameter("client_id");
		  String result = "";
		  VerificationMySQL sql = new VerificationMySQL();
		  try {
			  result = sql.SQL(verification, client_id);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		  res.setContentType("text/plain");
		  res.setCharacterEncoding("UTF-8");
		  res.getWriter().write(result);	
	  }
}
