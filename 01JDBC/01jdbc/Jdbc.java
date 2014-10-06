import java.sql.*;

class Jdbc
{
	public static void main(String args[])
	{
		Connection con= null;
		Statement stmt = null;
		String url="jdbc:mysql://localhost:3306/mydb";
		String un="root";
		String up="java";

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

	}
}