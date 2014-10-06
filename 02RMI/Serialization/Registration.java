import java.rmi.*;
import java.rmi.server.*;
import java.net.*;

public class Registration
{
	public static void main(String args[])
	{
		IStudent is=null;
		try
		{
			is=new SStudent();		
			Naming.rebind("object",is);
		}catch(Exception e)
		{System.out.println(e.getMessage());
		}
	}
}