import java.rmi.*;
import java.rmi.server.*;
public interface Itime extends Remote
{
	String getTime() throws RemoteException;
	String getEcho(String s) throws RemoteException;
}
