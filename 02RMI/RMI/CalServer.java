import java.rmi.*;
import java.rmi.server.*;
public class CalServer extends UnicastRemoteObject implements Icalculator
{
	public CalServer() throws RemoteException
	{
	}
	public int add(int x,int y) throws RemoteException
	{
		return x+y;
	}
}