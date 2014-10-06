import java.rmi.*;
import java.rmi.server.*;
import java.net.*;
public class CalClient
	{
		public static void main(String args[])
		{
		String url="rmi://localhost/object ";
		Icalculator ic=null;
		try
		{
			ic=(Icalculator)Naming.lookup(url);
			int x=ic.add(8,4);
			System.out.println("Total is"+x);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}