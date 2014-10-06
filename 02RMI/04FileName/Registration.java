import java.rmi.*;
import java.rmi.server.*;
import java.net.*;
public class Registration
{
	public static void main(String args[])
	{
		SFileRead sif=null;
		try
		{
			sif =new SFileRead();
			Naming.rebind("object",sif);
		}catch(Exception e)
		{
		System.out.println(e.getMessage());
		}
	}
}