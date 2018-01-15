package com.herokuapp.vafood.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ToGetReviewsMySQL {
	public JSONArray SQL() throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionUtils.getMyConnection();

		// Create statement
		Statement statement = connection.createStatement();

		String sql = "SELECT client.name, reviews.date, reviews.review  FROM client inner join reviews on client.client_id=reviews.client_id";
		ResultSet rs = statement.executeQuery(sql);
		JSONArray employeeList = new JSONArray();

		while (rs.next()) {
			JSONObject employee = createEmployee(rs);
			employeeList.add(employee);
		}
		// Close connection.
		connection.close();
		return employeeList;
	}

	private JSONObject createEmployee(ResultSet rs) throws SQLException {
		JSONObject obj = new JSONObject();
		String name = rs.getString("name");
		String review = rs.getString("review");
		String date = rs.getString("date");
		obj.put("name", name);
		obj.put("date", date);
		obj.put("review", review);
		return obj;
	}
}