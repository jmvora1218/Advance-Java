import java.rmi.*;
import java.rmi.server.*;

public class CFileName
{
	public static void main(String args[])
	{
		String url="rmi://localhost:1099/object";
		IFileRead ifn=null;
		try
		{
			ifn=(IFileRead)Naming.lookup(url);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}