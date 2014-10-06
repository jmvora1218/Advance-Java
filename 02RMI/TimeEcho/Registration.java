import java.rmi.*;
import java.rmi.server.*;
import java.net.*;

public class Registration
{
	public static void main(String args[])
	{
	TimeServer ts=null;
	try
	{
	ts=new TimeServer();
	Naming.rebind("object",ts);
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	}
}