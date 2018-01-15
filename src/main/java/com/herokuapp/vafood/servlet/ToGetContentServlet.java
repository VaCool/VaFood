package com.herokuapp.vafood.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;

import com.herokuapp.vafood.mysql.ToGetContentMySQL;

@WebServlet(urlPatterns = { "/pizza", "/paste", "/risotto", "/dessert" })
public class ToGetContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String servletPath = req.getServletPath();
		servletPath = servletPath.replace("/", "");
		String data = servletPath;
		ToGetContentMySQL sql = new ToGetContentMySQL();
		JSONArray obj = new JSONArray();
		try {
			obj = sql.SQL(data);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		res.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		out.print(obj);

	}
}