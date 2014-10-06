import java.sql.*;
import java.util.*;


public class labq2 {
    
    public static void main(String args[]) throws Exception { 
        
        Connection con=null;
		Statement stmt=null;
		String url="jdbc:mysql://localhost/lab";
		String un="root";
		String up="java";
		ResultSet rs=null;
		Scanner sc=new Scanner(System.in);
		String usrname,usrpass,gun=null,gup=null;
		
		
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded.");
		con=DriverManager.getConnection(url,un,up);
		System.out.println("Connection Created..");
		stmt=con.createStatement();
		System.out.println("Wraper created...");
		
		
		System.out.println("Enter user name: ");
		usrname=sc.next();
		System.out.println("Enter password: ");
		usrpass=sc.next();
                
		rs = stmt.executeQuery("SELECT * FROM employee WHERE NAME='"+usrname+"'");
		
		if(rs.next()==false)
		{ 
			System.out.println("No username registered!");
		}
		else
		{ 
			String print = rs.getString("PASSWORD");
			if(print.equals(usrpass))
			{ 
				System.out.println("Welcome " + usrname);
			}
			else
			{ 
				System.out.println("Invalid password!");
			}
		}
    }  
}