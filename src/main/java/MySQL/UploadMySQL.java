package MySQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UploadMySQL {
	public String SQL(String name, String weight, String price, String url, String consist, String categories, String data) throws ClassNotFoundException,
    SQLException{
        Connection connection = ConnectionUtils.getMyConnection();
        
        // Create statement
        Statement statement = connection.createStatement();   
        String sql = "INSERT INTO " + data + " VALUES(NULL, '"
        		+ name + "', '" + weight + "', '" + price + "', '" + url + "', '" + consist + "', '" + categories + "')";
        System.out.println(sql);
       
        int rowCount = statement.executeUpdate(sql); 
        
	    connection.close();
		return "Данные сохраненны";          
	}
}
