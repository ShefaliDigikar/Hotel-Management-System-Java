package hotel;


import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
	
	Connection connect;
	
	public Connection getConnection()
	{   
	
		String url,user,pwd;
		url="jdbc:mysql://localhost/renaissance?serverTimezone=UTC";
		user="root";
		pwd="";
	
		try {
		
			 connect =DriverManager.getConnection(url, user, pwd);
           
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return connect;
		
	}

}
