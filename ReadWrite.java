import java.io.*;

public class ReadWrite
{
	public static void main(String args[])
	{
		ObjectInputStream ois=null;//read
		ObjectOutputStream oos=null;//write
		
		Student st=new student(4,"room");
		oos=new ObjectOutputString(new FileOutputStream("D://test.txt"));
		oos.writeObject(st);
		
		ois=new ObjectInputStream(new FileInputStream("D://test.txt"));
		
		student st1=(student)ois.readObject();
		st1.display();
	}
}