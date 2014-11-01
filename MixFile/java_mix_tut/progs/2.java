import java .util.*;
class Ractangle
{
	private int length,width;
	public void initialize(int l,int w)
	{
		length=l;
		width=w;
	}
	public void display()
	{
		System.out.println("length of rectangle= "+length);
		System.out.println("width of rectangle= "+width);
	}
	public int area()
	{
		int x=length*width;
		return x;
	}
	public int perimeter()
	{
		int y=2*(length+width);
		return y;
	}
}
class demo2
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the length of ractangle: ");
		int a=sc.nextInt();
		System.out.print("Enter the width of ractangle: ");
		int b=sc.nextInt();
		Ractangle c=new Ractangle();
		c.initialize(a,b);
		c.display();
		int x=c.area();
		int y=c.perimeter();
		System.out.println("Area of ractangle is "+x+" & perimeter is "+y);
	}
}