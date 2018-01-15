package com.herokuapp.vafood.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONObject;

public class LoginMySQL {
	public   JSONObject SQL(String loginForChek, String passwordForChek) throws ClassNotFoundException,
    SQLException{
        Connection connection = ConnectionUtils.getMyConnection();
        
        // Create statement
        Statement statement = connection.createStatement();       
        System.out.println("hi");
        String sql = "SELECT login, password, verification, rights, name, client_id FROM client WHERE login = '" + loginForChek
        		+ "' AND password = '" + passwordForChek + "';";
        ResultSet rs = statement.executeQuery(sql);
        System.out.println(rs);
        System.out.println(rs);
        JSONObject obj = new JSONObject();
        if (rs.next()) {
        	 int client_id = rs.getInt("client_id");
             System.out.println(client_id);
             String name  = rs.getString("name");
             String login  = rs.getString("login");
             String password  = rs.getString("password");
             String rights  = rs.getString("rights");
             String verification  = rs.getString("verification");
             System.out.println(verification);
             System.out.println(rights);
             System.out.println(name);
             System.out.println(login);
             System.out.println(password);
             obj.put("login" , login );
             obj.put("password" ,password );
             obj.put("verification" ,verification );
             obj.put("rights" ,rights );
             obj.put("name", name );
             obj.put("client_id",client_id);
             connection.close();
             return obj;
        	} else {
                connection.close();
                System.out.println("Пусто");
                return obj;
        	}

	}
}
