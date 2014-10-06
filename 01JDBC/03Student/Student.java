import java.sql.*;
import java.util.*;
class Student
	{
		public static void main(String args[])
		{
		Connection con= null;
		Statement stmt = null;
		String url="jdbc:mysql://localhost:3306/mydb";
		String un="root";
		String up="java";
		int rn,m1,m2;
		String n,add,sql;
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
		System.out.println("Enter rollno");
		rn=sc.nextInt();
		System.out.println("Enter name");
		n=sc.next();
		System.out.println("Enter mark 1");
		m1=sc.nextInt();
		System.out.println("Enter mark 2");
		m2=sc.nextInt();
		System.out.println("Enter address");
		add=sc.next();
		sql="insert into st1 values("+rn+",'"+n+"',"+m1+","+m2+",'"+add+"')";
		System.out.println(sql);
		try{
		int r=stmt.executeUpdate(sql);
		System.out.println("data inserted"+r);
		}
		catch(SQLException sqle)
		{
		System.out.println("Data is not inserted"+sqle.getMessage());
		}
	}
}