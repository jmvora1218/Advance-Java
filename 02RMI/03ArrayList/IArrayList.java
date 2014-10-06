import java.rmi.*;
import java.rmi.server.*;

public interface IArrayList extends Remote
{
	void adddata(String d) throws RemoteException;
	String searchdata(String d) throws RemoteException;
}