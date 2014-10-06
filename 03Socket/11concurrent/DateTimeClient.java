import java.io.*;
import java.net.*;

class DateTimeClient
{
	public static void main(String args[])
	{
	Socket s=null;
	ObjectInputStream ois=null;
	ObjectOutputStream oos=null;
	
	try
	{
		s=new Socket("localhost",1444);
		System.out.println("Connected");
		ois=new ObjectInputStream(s.getInputStream());
		oos=new ObjectOutputStream(s.getOutputStream());
	}catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	
	try
	{
		String d=(String)ois.readObject();
		System.out.println("Date is: " +d);
	}catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
}
}