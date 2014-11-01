import java.rmi.*;
import java.rmi.server.*;

public interface Emplo extends Remote
{
String insertdata(String un,String up)throws RemoteException;
}