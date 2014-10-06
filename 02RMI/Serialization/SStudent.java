import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;
import java.util.*;

public class SStudent extends UnicastRemoteObject implements IStudent
{
	Connection con=null;
	Statement stmt=null;
	String url="jdbc:mysql://localhost:3306/mydb";
	String un="root";
	String up="java";
	public SStudent() throws RemoteException
	{
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver is loaded.");
		
		con=DriverManager.getConnection(url,un,up);
		System.out.println("Connection Created.");
		
		stmt=con.createStatement();
		System.out.println("Wrapper Created.");
	}
	catch(SQLException sqle)
	{
		System.out.println("Could not connected ...  " + sqle.getMessage());
		//return;
	}
	catch(ClassNotFoundException cnfe)
	{
		System.out.println("Driver can not connected ....  " + cnfe.getMessage());
		//return;
	}
	}
	
	public String insertData(Student st)throws RemoteException
	{
		String sql="insert into student values('"+st.getrn()+"','"+st.getName()+"')";
	
	try
	{
		stmt.executeUpdate(sql);
		return "inserted";
	}catch(SQLException sqle)
	{
		return ("Error" + sqle.getMessage());
	}
	}
}