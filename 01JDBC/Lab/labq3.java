import java.sql.*;
import java.util.*;

class labq3
{
	public static void main(String args[])
	{
		Connection con=null;
		Statement stmt=null;
		Statement stmt2=null;
		String url="jdbc:mysql://localhost/lab";
		String un="root";
		String up="java";
		ResultSet rs=null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loaded...");
			con=DriverManager.getConnection(url,un,up);
			System.out.println("Connection Created...");
			stmt=con.createStatement();
			stmt2=con.createStatement();
			System.out.println("Wraper Created...");
		}catch(Exception e)
		{
			System.out.println("Exception in 3-lines" + e.getMessage());
		}
		
		try
		{
			int EMPID=0;
			String EMPNAME=null,DESIGNATION=null,sql;
			
			rs=stmt.executeQuery("select * from EMP1");
			while(rs.next())
			{
			EMPID=rs.getInt("EMPID");
			EMPNAME=rs.getString("EMPNAME");
			DESIGNATION=rs.getString("DESIGNATION");
			
			sql="insert into EMP2 values("+EMPID+",'"+EMPNAME+"','"+DESIGNATION+"')";
			System.out.println(sql);
			
			try
			{
				int r=stmt2.executeUpdate(sql);
				System.out.println("inserted data is "+ r );
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			}
		}catch(SQLException sqle)
		{
			System.out.println(sqle.getMessage());
		}
	}
}
			