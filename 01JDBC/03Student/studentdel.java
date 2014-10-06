import java.sql.*;
import java.util.*;

class studentdel
{
	public static void main(String args[])
	{
		Connection con=null;
		Statement stmt=null;
		String url="jdbc:mysql://localhost:3306/mydb";
		String un="root";
		String up="java";
		int rn;
		String sql;
		Scanner sc=new Scanner(System.in);
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver is loaded... ");
		con=DriverManager.getConnection(url,un,up);
		System.out.println("Connection is Created... ");
		stmt=con.createStatement();
		System.out.println("Wrapper Created... ");
		}catch(Exception e)
		{
			System.out.println("Exception in JDBC line " +e.getMessage());
		}
		
		System.out.println("Enter the roll no: ");
		rn=sc.nextInt();
		
		sql="delete from st1 where rn ="+rn+" ";
		
		try
		{
			int r=stmt.executeUpdate(sql);
			System.out.println("Date is deleted = "+ r);
		}catch(SQLException sqle)
		{
			System.out.println("Invalid input "+ sqle.getMessage());
		}
	}
}