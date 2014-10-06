import java.rmi.*;
import java.rmi.server.*;
import java.net.*;
public class Registration
	{
	public static void main(String args[])
	{
		CalServer cs=null;
			try
			{
				cs=new CalServer();
				Naming.rebind("object",cs);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
	}
}