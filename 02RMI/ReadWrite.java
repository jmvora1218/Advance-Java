import java.io.*;


class ReadWrite
{
	public static void main(String args[])
	{
		ObjectInputStream ois=null;
		ObjectOutputStream oos=null;
		
		student st =new student(4,"Room");
		oos=new ObjectOutputStream(new FileOutputStream("D://hello.txt"));
		
		oos.writeObject(st);
		
		ois=new ObjectInputStream(new FileInputStream("D://hello.txt"));
		
		student st1=(student)ois.readObject();
		st1.display();
	}
}