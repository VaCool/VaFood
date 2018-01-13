package MySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONObject;

public class VerificationMySQL {
	public String SQL(String verification, String client_id) throws ClassNotFoundException,
    SQLException{
        Connection connection = ConnectionUtils.getMyConnection();
        
        // Create statement
        Statement statement = connection.createStatement();   
        String sql = "SELECT rights FROM client WHERE client_id = '" + client_id + "' AND verification = '" + verification + "'";
        ResultSet rs = statement.executeQuery(sql);
        if (rs.next()) {
        	connection.close();
             return "true";
        	} else {
                connection.close();
                return "false";
        	}
	}
	
	
	
	
	
	
}
