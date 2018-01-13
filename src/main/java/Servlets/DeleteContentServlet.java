package Servlets;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MySQL.DeleteContentMySQL;
@WebServlet(urlPatterns = { "/delpizza", "/delpaste", "/delisotto", "/deldessert" })
public class DeleteContentServlet extends HttpServlet{
	  public void doPost(HttpServletRequest req, HttpServletResponse res)
			  throws ServletException, IOException {		  
		  String data = req.getServletPath().replace("/del","");
		  String id =  req.getParameter("id");
		  String url =  req.getParameter("URL");	
		  url = url.substring(1, url.length());
		  String result = "";
		  System.out.println(url);
		  String appPath = "C:"+ File.separator + "Users" + File.separator + "VaCool" + File.separator + "workspace" +
					File.separator + "webapp" + File.separator + "src" + File.separator + "main" + File.separator + "webapp"  + url;
		  try{		  
	            File file = new File(appPath);
	            if(file.delete()){
	                System.out.println(file.getName() + " is deleted!");
	                DeleteContentMySQL sql = new DeleteContentMySQL();
	      		  try {
	      			  result = sql.SQL(id, data);
	      			} catch (ClassNotFoundException e) {
	      				e.printStackTrace();
	      			} catch (SQLException e) {
	      				e.printStackTrace();
	      			}
	                
	                
	                
	            }else{
	                System.out.println("Delete operation is failed.");
	            }	 
	        }catch(Exception e){
	            e.printStackTrace();
	        }
		  res.setContentType("text/plain");
		  res.setCharacterEncoding("UTF-8");
		  res.getWriter().write(result);	
	  }
}

	
	
	
