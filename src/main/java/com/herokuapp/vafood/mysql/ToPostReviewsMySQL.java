package com.herokuapp.vafood.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ToPostReviewsMySQL {
	public String SQL(String review, String client_id) throws ClassNotFoundException,
    SQLException{
        Connection connection = ConnectionUtils.getMyConnection();
        
        // Create statement
        Statement statement = connection.createStatement();   
        String sql = "INSERT INTO reviews VALUES(NULL, NOW(), '" + review + "', " + client_id + ")";
        int rowCount = statement.executeUpdate(sql); 
        System.out.println(sql);
	    connection.close();
		return "Спасибо за отзыв";          
	}
}
