package Servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import MySQL.RegistrationMySQL;


@WebServlet(urlPatterns = { "/registration"})
public class RegistrationServlet extends HttpServlet{
	 private static final long serialVersionUID = 1L;
	 

	  public void doPost(HttpServletRequest req, HttpServletResponse res)
			  throws ServletException, IOException {
		  
		  String name =  req.getParameter("name");
		  String login =  req.getParameter("login");
		  String password = req.getParameter("password");
		  String email =  req.getParameter("email");
		  String phone =  req.getParameter("phone");
		  String verification =  req.getParameter("verification");
		  String result = "";

		  RegistrationMySQL sql = new RegistrationMySQL();
		  try {
			  result = sql.insert(name, login, password, email, phone, verification);
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

