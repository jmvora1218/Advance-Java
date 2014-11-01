import java.rmi.*;
import java.rmi.server.*;
import java.net.*;

public class Registeration2
{
public static void main(String args[])
{
EServer es=null;
try
{
es=new EServer();
Naming.rebind("Obj",es);
}
catch(Exception e)
{
System.out.println(e.getMessage());
}
}
}