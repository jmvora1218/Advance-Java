import java.rmi.*;
import java.rmi.server.*;
public interface Icalculator extends Remote
{
	int add(int x,int y) throws RemoteException;
}