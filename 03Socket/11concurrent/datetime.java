import java.io.*;
import java.net.*;
import java.util.*;

public class datetime
{
	public static void main(String args[])
	{
		ServerSocket ss=null;
		Socket s=null;
		
		try
		{
			ss=new ServerSocket(1444);
			System.out.println("Server create...");
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		while(true)
		{
			System.out.println("Waiting for connection...");
			try
			{
				s=ss.accept();
				System.out.println("Server connected");
				new DateTimeConcurrent(s);
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
}