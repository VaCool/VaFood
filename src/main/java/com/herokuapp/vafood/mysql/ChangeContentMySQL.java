package com.herokuapp.vafood.mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ChangeContentMySQL {
	public String SQL(String id, String name, String weight, String price, String consist, String categories, String data) throws ClassNotFoundException,
    SQLException{
        Connection connection = ConnectionUtils.getMyConnection();
        
        // Create statement
        Statement statement = connection.createStatement();   
        String sql = "UPDATE pizza  SET  name = '" + name + "', weight = '"+ weight + "', price = '" + price + "', consist = '" 
        + consist +"', categories = '" + categories + "' WHERE "+ data + "_id = " + id;
        int rowCount = statement.executeUpdate(sql); 
        System.out.println(sql);
	    connection.close();
		return "Данные записаны успешно!";          
	}

}
