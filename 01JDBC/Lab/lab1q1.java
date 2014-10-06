import java.sql.*;
import java.util.*;

class lab1q1
{
	public static void main(String args[])
	{
		Connection con=null;
		Statement stmt=null;
		String url="jdbc:mysql://localhost/lab";
		String un="root";
		String up="java";
		ResultSet rs=null;
		int m1,m2,m3,ans,rn;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loaded");
			con=DriverManager.getConnection(url,un,up);
			System.out.println("Connection Created...");
			stmt=con.createStatement();
			System.out.println("Wraper created...");
		}catch(Exception e)
		{
			System.out.println("Exception in 3-lines" + e.getMessage());
		}
		
		try
		{
			rs=stmt.executeQuery("select * from student");
			while(rs.next())
			{
				rn=rs.getInt("rn");
				m1=rs.getInt("sub1");
				m2=rs.getInt("sub2");
				m3=rs.getInt("sub3");
				ans=(m1+m2+m3)/3;
				System.out.println("roll no is: " + rn + "Ans is: " +ans);
				
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}