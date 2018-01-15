package com.herokuapp.vafood.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.herokuapp.vafood.mysql.ToPostReviewsMySQL;
import com.herokuapp.vafood.mysql.UploadMySQL;

@WebServlet(urlPatterns = { "/uploadpizza", "/uploadpaste", "/uploadrisotto", "/uploaddessert" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class UploadServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String name =   new String(req.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		String weight =  req.getParameter("weight");
		String price =  req.getParameter("price");
		String consist = new String(req.getParameter("consist").getBytes("ISO-8859-1"),"UTF-8");

		
		String first = req.getParameter("first");
		String second = req.getParameter("second");
		String popular = req.getParameter("popular");
		String veryNew = req.getParameter("new");
		String categories = "all";
		String result = "";
		if(first != null){
			categories = categories + " first";
		}
		if(second != null){
			categories = categories + " second";
		}
		if(popular != null){
			categories = categories + " popular";
		}
		if(veryNew != null){
			categories = categories + " new";
		}
		
		System.out.println(name);
		System.out.println(price);
		System.out.println(categories);
		System.out.println(weight);
		System.out.println(consist);
		
		
		String SAVE_DIR = req.getServletPath().replace("/upload", "");
		String appPath = "C:"+ File.separator + "Users" + File.separator + "VaCool" + File.separator + "workspace" +
		File.separator + "webapp" + File.separator + "src" + File.separator + "main" + File.separator + "webapp"  + File.separator + "img";
		String savePath = appPath + File.separator + SAVE_DIR;

		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}

		for (Part part : req.getParts()) {
			String fileName = extractFileName(part);
			if (fileName.equals("")) {
				continue;
			} else {
				System.out.println(savePath + File.separator + fileName);
				fileName = new File(fileName).getName();
				part.write(savePath + File.separator + fileName);
				String url = "./img/" + SAVE_DIR + "/" + fileName;
				System.out.println(url);
				UploadMySQL sql = new UploadMySQL();
				
				  try {
					  result = sql.SQL(name, weight, price, url, consist, categories, SAVE_DIR);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				  break;
			}
		}
		  res.setContentType("text/plain");
		  res.setCharacterEncoding("UTF-8");
		  res.getWriter().write(result);
	}

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}
}