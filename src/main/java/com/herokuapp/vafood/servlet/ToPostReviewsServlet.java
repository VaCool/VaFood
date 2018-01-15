package com.herokuapp.vafood.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.herokuapp.vafood.mysql.ToPostReviewsMySQL;

@WebServlet(urlPatterns = {"/sendreviews"})
public class ToPostReviewsServlet  extends HttpServlet{
	  public void doPost(HttpServletRequest req, HttpServletResponse res)
			  throws ServletException, IOException {
		  
		  String review =  req.getParameter("review");
		  String client_id =  req.getParameter("client_id");
		  String result = "";
		  System.out.println(review);
		  System.out.println(client_id);
		  ToPostReviewsMySQL sql = new ToPostReviewsMySQL();
		  try {
			  result = sql.SQL(review, client_id);
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
