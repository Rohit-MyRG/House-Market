package com.compassion.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import static com.compassion.dao.MySqlProvider.*;

public class MySqlConnectionProvider {
	private static Connection con=null;  
	
	static{  
		try{  
			Class.forName(DRIVER);  
			con=DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD);  
		}catch(Exception e){}  
	}  
	  
	public static Connection getConnection(){  
	    return con;  
	}  

}
