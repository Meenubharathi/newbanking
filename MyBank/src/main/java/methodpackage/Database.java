package methodpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database
{
	public static Connection connection() 
    {
	    String DB_URL="jdbc:mysql://localhost:3306/inc15";//if "no suitable driver found" sql exception then you want connect your project with jar that you have downloded
        String DB_USERNAME="root";
        String DB_PASSWORD="Root@123";	 
      
   	 Connection connect=null;
   	 try
   	 {
   			connect=DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
   		if(connect!=null)
   		{
   			//System.out.println("DB connected");
   		}
   		else
   		{
   			System.out.println("DB Not connect");
   		}
   		
   		}catch(SQLException ex)
   	 {
   		 ex.printStackTrace();
   	 }
   	 return connect;
    }
	
}
