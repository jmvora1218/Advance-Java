import java.rmi.*;
import java.rmi.server.*;
import java.net.*;

public class CStudent 
{
	public static void main(String args[])
	{	
	String url="rmi://localhost:1099/object";
	IStudent is=null;
	try
	{
		is=(IStudent)Naming.lookup(url);
		Student st=new Student(1218,"Rib",9);
		String d=is.insertData(st);
		System.out.println(d);
	}
	catch(Exception e)
	{
	System.out.println(e.getMessage());
	}
	}
}		