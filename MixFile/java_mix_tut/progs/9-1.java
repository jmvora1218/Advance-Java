import java.util.*;
class Calculator
{
	private float a,b;
	public void initialize(float x,float y)
	{
		a=x;
		b=y;
	}
	public void display()
	{
		System.out.println("Entered numbers are : "+a+" "+b);
	}
	public float noSum()
	{
		float c=a+b;
		return c;	
	}
	public float noDiff()
	{
		float c=a-b;
		if(c>=0)
			return c;
		else
			return (-c);	
	}
	public float noMul()
	{
		float c=a*b;
		return c;	
	}
	public float noDiv()
	{
		float c;
		if(b==0)
			c=b/a;
		else
			c=a/b;
		return c;
	}
}
class Demo9
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter any two Float nos:  ");
		float a=sc.nextFloat();
		float g=sc.nextFloat();
		Calculator c=new Calculator();
		c.initialize(a,g);
		c.display();
		float b=c.noSum();
		System.out.println("Sum of two entered no: "+b);
		float d=c.noDiff();
		System.out.println("Difference between two entered no: "+d);
		float e=c.noMul();
		System.out.println("Multiplication of two entered no: "+e);
		float f=c.noDiv();
		System.out.println("Division of two entered no: "+f);
		
	}
}