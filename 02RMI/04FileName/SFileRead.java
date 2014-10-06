import java.rmi.*;
import java.rmi.server.*;
import java.io.*;

public class SFileRead extends UnicastRemoteObjet implements IFileRead
{
	FileInputStream fis;
	char x;
	int d;
	String data;
	public SFileRead() throws RemoteException
	{//abstract method...
	}
	public String readfile(String fim) throws RemoteException
	{
		try
		{
			fis=new FileInputStream();
			data="";
			while(true)
			{
				d=fis.read("C:\\Users\\SHREEJI\\Documents\\EagleGet Downloads\\proguard-project.txt");
				if(d==-1)
				{
					break;
				}
				x=(char)d;
				data=data+x;
			}
			return data;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}