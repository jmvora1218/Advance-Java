import java.io.Serializable;

public class Student implements Serializable
{
	private int rn;
	private String name;
	private double cpi;
	Student()
	{}
	Student(int rn,String name,double cpi)
	{
		this.rn=
	}
	public void setrn(int r)
	{
	rn=r;
	}
	public int getrn()
	{
	return rn;
	}
	public void setName(String n)
	{
	name=n;
	}
	public String getName()
	{
	return name;
	}
	public void display()
	{
	System.out.println(rn+" "+name);
	}
}