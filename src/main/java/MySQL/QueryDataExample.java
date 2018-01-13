package MySQL;


 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
 

 
public class QueryDataExample {

	public JSONArray SQL(String data) throws ClassNotFoundException,
    SQLException{
        Connection connection = ConnectionUtils.getMyConnection();
        
        // Create statement
        Statement statement = connection.createStatement();
 
        String sql = "Select * from " + data;
        ResultSet rs = statement.executeQuery(sql);
		
		JSONArray employeeList = new JSONArray();

		 while (rs.next()) {

			 JSONObject obj = new JSONObject();
	            int id = rs.getInt(data+"_id");
	            String name  = rs.getString("name");
	            String weight  = rs.getString("weight");
	            String price  = rs.getString("price");
	            String URL  = rs.getString("URL");
	            String consist  = rs.getString("consist");	         
	            String categories = rs.getString("categories");
	            obj.put(data+"_id", id);
	            obj.put("name", name );
	            obj.put("weight" ,weight );
	            obj.put("price" ,price );
	            obj.put("URL" , URL );
	            obj.put("consist" ,consist );
	            obj.put("categories" ,categories );
	            employeeList.add(obj);
	 }
	        // Close connection.
	        connection.close();
		return employeeList;
	}
    
  
 
      

 
  }
 
