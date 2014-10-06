import java.rmi.*;
import java.rmi.server.*;

public interface Ical extends Remote
{
	public int add(int x,int y)throws RemoteException;
}	