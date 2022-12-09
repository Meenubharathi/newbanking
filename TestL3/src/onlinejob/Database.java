package onlinejob;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database 
{
    public static Connection connect()
    {
    	String DB_URL="jdbc:mysql://localhost:3306/onlinejob";
    	String DB_USERNAME="root";
    	String PASSWORD="Root@123";
    	
    	Connection connect=null;
    	try
    	{
    		connect=DriverManager.getConnection(DB_URL, DB_USERNAME,PASSWORD);
    		if(connect!=null)
    		{
    			//System.out.println("DB connected");
    		}
    		else
    		{
    			System.out.println("DB not connected");
    		}
    	}catch(SQLException ex)
    	{
    		ex.printStackTrace();
    	}
    	return connect;	
    }
}
