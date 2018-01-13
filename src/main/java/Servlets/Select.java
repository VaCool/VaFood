package Servlets;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONArray;


import MySQL.QueryDataExample;
public class Select {
	 public static void main(String[] args) throws SQLException{
		 String data = "pizza";
		 QueryDataExample sql = new QueryDataExample();
		 JSONArray obj = new JSONArray();	
		 try {
			 obj = sql.SQL(data);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(obj);
	


		 
		/* while (rs.next()) {
	            int pizza_id = rs.getInt(1);
	            String name  = rs.getString("name");
	            String weight  = rs.getString("weight");
	            String price  = rs.getString("price");
	            String URL  = rs.getString("URL");
	            String consist  = rs.getString("consist");	         
	            String categories = rs.getString("categories");
	      
	            obj.put("pizza_id",pizza_id);
	            obj.put("name", name );
	            obj.put("weight" ,weight );
	            obj.put("price" ,price );
	            obj.put("URL" , URL );
	            obj.put("consist" ,consist );
	            obj.put("categories" ,categories );
	 }
	 */
	 }
	     
}
