import java.io.*;
import java.util.*;
import java.net.*;

public class pnoClient
{
	public static void main(String args[])
	{
		Socket s=null;
		ObjectInputStream ois=null;
		ObjectOutputStream oos=null;
		Scanner sc=new Scanner(System.in);
		String Data;
		
		try
		{
			s=new Socket("localhost",1444);
			System.out.println(" Client Connected to Server");
			
			ois=new ObjectInputStream(s.getInputStream());
			Data=(String)ois.readObject();
			System.out.println(Data);
			
			oos=new ObjectOutputStream(s.getOutputStream());
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		try
		{
		System.out.println((String)ois.readObject());
		oos.writeObject(sc.next());
		
		System.out.println((String)ois.readObject());
		oos.writeObject(sc.next());
		
		
		System.out.println("port is free :" + (String)ois.readObject());
		System.out.println("port is Busy :" + (String)ois.readObject());
		
		//System.out.println(Integer.parseInt((String)ois.readObject()));
		
		}catch(Exception e)
		{
			System.out.println("Exception is: "+e.getMessage());
		}
	}
}