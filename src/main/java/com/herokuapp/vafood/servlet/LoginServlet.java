package com.herokuapp.vafood.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.herokuapp.vafood.mysql.LoginMySQL;

@WebServlet(urlPatterns = { "/login"})
public class LoginServlet extends HttpServlet{
	 private static final long serialVersionUID = 1L;


	  public void doPost(HttpServletRequest req, HttpServletResponse res)
			  throws ServletException, IOException {

		  String loginForChek =  req.getParameter("login");
		  String passwordForChek = req.getParameter("password");

		  JSONObject result = new JSONObject();
		  LoginMySQL sql = new LoginMySQL();
		  try {
			  result = sql.SQL(loginForChek, passwordForChek);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		   if( result.toString().equals("{}")){
				  res.setContentType("text/plain");
				  res.setCharacterEncoding("UTF-8");
				  res.getWriter().write("Не верно введен логин или пароль!");	
		   }
		   else{
			   System.out.println( result.toString());
			   res.setCharacterEncoding("UTF-8");
			   res.setContentType("application/json");
			   PrintWriter out = res.getWriter();
			   out.print(result);
		   }

	}
}
