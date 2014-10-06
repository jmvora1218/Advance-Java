import java.io.*;
import java.net.*;
import java.util.*;
import java.sql.*;

class Empclient
{
	public static void main(String args[])
	{	
		Socket s=null;
		ObjectInputStream ois=null;
		ObjectOutputStream oos=null;
		Scanner sc=new Scanner(System.in);
		String data;
		
		try
		{
			s=new Socket("localhost",1444);
			System.out.println("CONNECTED");
		
			ois=new ObjectInputStream(s.getInputStream());
			oos= new ObjectOutputStream(s.getOutputStream());
		}
		catch(UnknownHostException UK)
		{
			System.out.println("HOST PROBLEM");
			return;
		}
		catch(IOException ioe)
		{
			System.out.println("IOError");
			return;
		}
	
		try
		{
			
			
			System.out.println((String)ois.readObject());
			oos.writeObject(sc.next());
			
			System.out.println((String)ois.readObject());
			oos.writeObject(sc.next());
			
			System.out.println((String)ois.readObject());
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}