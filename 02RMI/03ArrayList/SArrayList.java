import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class SArrayList extends UnicastRemoteObject implements IArrayList
{
	ArrayList al=new ArrayList();
	public SArrayList() throws RemoteException
	{
	}
	public void adddata(String d) throws RemoteException
	{
	al.add(d);
	}
	public String setdata(String d)
	{
		boolean flag=false;
		int l=d.length();
		String data="";
		for(int i=0;i<l;i++)
		{
			data+=d.charAt(i);
			if(data.equals(d));
			{
				flag=true;
			}
			if(flag)
			{
				return "Available";
			}
			else
			{
				return "NotAvailable";
			}
		}
		return d;
	}
	public String searchdata(String d) throws RemoteException
	{
		return d;
	}
}