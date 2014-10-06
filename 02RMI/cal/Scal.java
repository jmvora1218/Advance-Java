import java.rmi.*;
import java.rmi.server.*;
public class Scal extends UnicastRemoteObject implements Ical
{
	public Scal() throws RemoteException
	{
	}
	public int add(int x,int y) throws RemoteException
	{
	return x+y;
	}
}