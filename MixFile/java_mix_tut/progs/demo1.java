import java .util.*;
class Circle
{
	private int rad;
	public void initialize(int r)
	{
		rad=r;
	}
	public void display()
	{
		System.out.println("Radius of Circle= "+rad);
	}
	public double area()
	{
		double x=3.14*rad*rad;
		return x;
	}
	public double circumference()
	{
		double y=2*3.14*rad;
		return y;
	}
}
class demo1
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		Circle c[]=new Circle[3];
		int a;
		for(int i=0;i<c.length;i++)
		{
			c[i]=new Circle();
		}
		double x,y;
		for(int i=0;i<c.length;i++)
		{
			System.out.print("Enter the radius of circle: ");
			a=sc.nextInt();
			c[i].initialize(a);
			c[i].display();
			x=c[i].area();
			y=c[i].circumference();
			System.out.println("Area of circle is "+x+" & cirumference is "+y);
		}
	}
}