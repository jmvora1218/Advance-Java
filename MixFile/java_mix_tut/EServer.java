import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
import java.sql.*;

public class EServer extends UnicastRemoteObject implements Emplo
{
public class EServer()throws RemoteException
{
Connection con=null;
Statement stmnt=null;
ResultSet rs=null;


String url="jdbc:mysql://localhost:3306/mydb";
String un="root";
String up="java";

try
{
Class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver loaded");
con=DriverManager.getConnection(url,un,up);
System.out.println("Connected");
stmnt=con.createStatement();

System.out.println("Wrapper created");
}

catch(ClassNotFoundException cnfe)
{
System.out.println("Driver cant be loaded"+cnfe.getMessage());
return;
}
catch(SQLException sqle)
{
System.out.println("Could not connect"+sqle.getMessage());
return;
}

public String insertdata(String un,String up)throws RemoteException
{
stmnt.executeUpdate("insert into Emp4 values('"+un+"','"+up+"')");

}
}
}

