import java.io.*;
import java.net.*;

public class ackServer
{
	public static void main(String args[])
	{
		Socket s=null;
		ServerSocket ss=null;
		ObjectOutputStream oos=null;
		
		try
		{
			ss=new ServerSocket(1444);
			System.out.println("Server is Created");
		}catch(IOException ios)
		{
			System.out.println("Port is busy"+ios.getMessage());
			return;
		}
		
		while(true)
		{
			System.out.println("Waiting for connection");
			try
			{
				s=ss.accept();
				System.out.println("Connected");
				oos=new ObjectOutputStream(s.getOutputStream());
				oos.writeObject("GM");
			}catch(IOException ios)
			{
				System.out.println("I/O Exception Generated" + ios.getMessage());
			}
		}
	}
}