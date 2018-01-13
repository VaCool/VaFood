package MySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class RegistrationMySQL {
	public   String insert(String name, String login, String password, String email, String phone, String verification) throws ClassNotFoundException,
    SQLException{
        Connection connection = ConnectionUtils.getMyConnection();
        
        // Create statement
        Statement statement = connection.createStatement();  
        
        
        String sqlChek = "SELECT login FROM client";
        ResultSet rsChek = statement.executeQuery(sqlChek);
        String loginChek = "";
        while (rsChek.next()) {
        	loginChek  = rsChek.getString("login");
        	if (loginChek.equals(login)){
    	        connection.close();
        		return "Пользователь с таким логином уже сущестует!";
        	}
        }
        String sql = "INSERT INTO client VALUES(NULL, '" + name + "', '" + login + "', '" + password + "', '" + phone + "', NULL" + ", '" 
        + email + "', '" + verification + "');";
        int rowCount = statement.executeUpdate(sql);      
	    connection.close();
		return "Регистрация прошла успешно";
}
}