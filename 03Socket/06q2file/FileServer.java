import java.io.*;
import java.net.*;

class FileServer
{
	public static void main(String args[])
	{
		ServerSocket ss=null;
		Socket s=null;
		ObjectOutputStream oos=null;
		ObjectInputStream ois=null;
		char x;
		int d;
		FileInputStream fis=null;
		String data="";
		
		try
		{
			ss=new ServerSocket(1444);
			System.out.println("Server Created");
		}
		catch(IOException ioe)
		{
			System.out.println("Port is busy"+ioe.getMessage());
			return;
		}
		
		while(true)
		{
			System.out.println("Waiting for Connection...");
			
			try
			{
				s=ss.accept();
				System.out.println("Connected Succesfully");
				oos=new ObjectOutputStream(s.getOutputStream());
				oos.writeObject("Thai gayu la..");
				ois=new ObjectInputStream(s.getInputStream());
				
			}
			catch(IOException ioe)
			{
				System.out.println("Port is busy"+ioe.getMessage());
				
				return;
			}
			try
			{
				oos.writeObject("File no path nakh chal: ");
				String f=(String)ois.readObject();
				fis=new FileInputStream(f);
				
				while(true)
				{
					d=fis.read();
					if(d==-1)
					{
						break;
					}
					x=(char)d;
					data=data+x;
				}	
				oos.writeObject(data);
			}
			catch(Exception e)
			{
				System.out.println("Error "+e.getMessage());
			}
		}
	}
}	

