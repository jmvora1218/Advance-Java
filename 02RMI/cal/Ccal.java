import java.rmi.*;
import java.rmi.server.*;

public class Ccal
{
	public static void main(String args[])
	{
		String url="rmi://localhost:1099/object";
		Ical ic=null;
		try
		{
			ic=(Ical)Naming.lookup(url);
			int  z=ic.add(1,2);
			System.out.println("Answer is"+z);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
			