package com.herokuapp.vafood.mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteContentMySQL {
	public   String SQL(String id, String data) throws ClassNotFoundException,
    SQLException{
        Connection connection = ConnectionUtils.getMyConnection();
        
        // Create statement
        Statement statement = connection.createStatement();   
        String sql = "DELETE FROM `" + data + "` WHERE `" + data +"_id`=" + id;
                int rowCount = statement.executeUpdate(sql);      
        	    connection.close();
        		return "Регистрация прошла успешно";
        
        
	}
}
