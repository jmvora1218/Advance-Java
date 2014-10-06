import java.rmi.*;
import java.rmi.server.*;
import java.net.*;
public class Registration
	{
	public static void main(String args[])
	{
		Scal sc=null;
			try
			{
				sc=new Scal();
				Naming.rebind("object",sc);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
	}
}