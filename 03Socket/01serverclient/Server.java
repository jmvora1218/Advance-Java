import java.io.*;
import java.net.*;

public class Server
{
	public static void main(String args[])
	{
		ServerSocket ss=null;
		Socket s=null;
		
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
			}catch(IOException ios)
			{
				System.out.println("I/O Exception Generated" + ios.getMessage());
			}
		}
		//System.out.println("Server Terminate");
	}
}