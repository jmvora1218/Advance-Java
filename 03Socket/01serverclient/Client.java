import java.io.*;
import java.net.*;

public class Client
{
	public static void main(String args[])
	{
		Socket s=null;
		try
		{
			s=new Socket("localhost",1444);
			System.out.println("Connected");
		}
		catch(UnknownHostException uhe)
		{
			System.out.println("Host Problem" + uhe.getMessage());
			return;
		}
		catch(IOException ios)
		{
			System.out.println("I/O Error " + ios.getMessage());
			return;
		}
		
		System.out.println("Client terminal");
	}
}