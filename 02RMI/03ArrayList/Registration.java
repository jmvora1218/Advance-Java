import java.rmi.*;
import java.rmi.server.*;
import java.net.*;

public class Registration
{
	public static void main(String args[])
	{
		SArrayList sal=null;
		try
		{
			sal=new SArrayList();		
			Naming.rebind("object",sal);
		}catch(Exception e)
		{System.out.println(e.getMessage());
		}
	}
}
