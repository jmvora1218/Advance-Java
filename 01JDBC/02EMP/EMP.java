import java.sql.*;
import java.util.*;
class EMP
{
	public static void main(String args[])
	{
		{
		Connection con= null;
		Statement stmt = null;
		String url="jdbc:mysql://localhost:3306/mydb";
		String un="root";
		String up="java";
		String n,p,sql;
		Scanner sc=new Scanner(System.in);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loaded");
			con=DriverManager.getConnection(url,un,up);
			System.out.println("Connection created");
			stmt =con.createStatement();
			System.out.println("Wrapper created");
		}
		catch(SQLException sqle)
		{
			System.out.println("could not connected"+sqle.getMessage());
			return;
		}
		catch(ClassNotFoundException cnfe)
		{
			System.out.println("Driver could not loaded"+cnfe.getMessage());
			return;
		}

		System.out.println("Enter name");
		n=sc.next();
		System.out.println("Enter password");
		p=sc.next();
		sql="insert into emp values('"+n+"','"+p+"')";
		System.out.println(sql);
		try
		{
		int r =stmt.executeUpdate(sql);
		System.out.println("Data inserted ...."+r);
		}
		catch(SQLException sqle)
		{
			System.out.println("data not inserted"+sqle.getMessage());
		}
	}
}
}
