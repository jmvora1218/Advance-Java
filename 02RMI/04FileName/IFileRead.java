import java.rmi.*;
import java.rmi.server.*;

public interface IFileRead extends Remote
{
	String readfile(String filename)throws RemoteException;
}