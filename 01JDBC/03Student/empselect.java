import java.sql.*;
import java.util.*;

public class empselect
{
		public static void main(String args[])
	{
		String n=null;
		String p=null;
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		String url="jdbc:mysql://localhost/mydb";
		String un="root";
		String up="java";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is Connected...");
			con=DriverManager.getConnection(url,un,up);
			System.out.println("Connection Created...");
			stmt=con.createStatement();
			System.out.println("Wrapper Created... ");
		}catch(Exception e)
		{
			System.out.println("Exception in JDBC line " +e.getMessage());
		}
		
		try
		{
			rs=stmt.executeQuery("select * from emp");
			while(rs.next())
			{
				n=rs.getString("n");
				p=rs.getString("p");
				System.out.println(n+"  "+p);
			}
		}catch(SQLException sqle)
			{
				System.out.println(sqle.getMessage());
			}
	}
}