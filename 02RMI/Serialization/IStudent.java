import java.rmi.*;
import java.rmi.server.*;

public interface IStudent extends Remote
{
	String insertData(Student st) throws RemoteException ;
}