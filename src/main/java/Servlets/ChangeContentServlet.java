package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MySQL.ChangeContentMySQL;
@WebServlet(urlPatterns = { "/changepizza","/changepaste" ,"/changerisotto", "/changedessert"})
public class ChangeContentServlet  extends HttpServlet{
	  public void doPost(HttpServletRequest req, HttpServletResponse res)
			  throws ServletException, IOException {		  
		  String data = req.getServletPath();
		  data = data.replace("/change","");
		  String id =  req.getParameter("id");
		  String name =  req.getParameter("name");
		  String weight =  req.getParameter("weight");
		  String price =  req.getParameter("price");
		  String consist =  req.getParameter("consist");
		  String categories =  req.getParameter("categories");		  
		  String result = "";
		  

		  ChangeContentMySQL sql = new ChangeContentMySQL();
		  try {
			  result = sql.SQL(id, name, weight, price, consist, categories, data);
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