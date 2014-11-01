import java.util.*;
class Distance
{
	private int inch;
	public void initialize(int i)
	{
		inch=i;
	}
	public void display()
	{
		System.out.println("Inches: "+inch);
	}
	public void feetInch()
	{
		int f=inch/12;
		inch=inch%12;
		System.out.println("Distance= "+f+ " Foot & "+inch+" Inch");
		
	}	
}
class Demo5
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the Distance in inches:  ");
		int a=sc.nextInt();
		Distance d=new Distance();
		d.initialize(a);
		d.display();
		d.feetInch();
	}
}