import java.util.*;
import java.rmi.*;
import java.rmi.server.*;
public class TimeServer extends UnicastRemoteObject implements Itime
{
	public TimeServer() throws RemoteException
	{
	}
	public String  getTime () throws RemoteException
	{
	Date d=new Date();
	String date=d.toString();
	return date;
	}
	public String getEcho(String s) throws RemoteException
	{
	return s;
	}
	}
	 
 