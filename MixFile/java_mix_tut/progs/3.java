import java.util.*;
class Loan
{
	private int p_Amount,year;
	private double r_Interest;
	public void initialize(int p,double r,int y)
	{
		p_Amount=p;
		r_Interest=r;
		year=y;
	}
	public void display()
	{
		System.out.println("Principle Amount: "+p_Amount);
		System.out.println("Rate of Interest: "+r_Interest);	
		System.out.println("Number of Years: "+year);
	}
	public double simpleInterest()
	{
		double ans=p_Amount*r_Interest*year/100;
		return ans;
	}
	public double compoundInterest()
	{
		double ans=1;
		for(int i=1;i<=year;i++)
		{
			ans=ans*(1+(r_Interest/100));
		}
		ans=p_Amount*ans;
	return ans;
	}	
}
class Demo3
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the amount of principle:  ");
		int a=sc.nextInt();
		System.out.print("Enter the rate of interest: ");
		double b=sc.nextDouble();
		System.out.print("Enter the year of investment: ");
		int c=sc.nextInt();
		Loan l=new Loan();
		l.initialize(a,b,c);
		l.display();
		double x=l.simpleInterest();
		System.out.println("Simple Interest = "+x);
		double y=l.compoundInterest();
		System.out.println("Compound Interest = "+y);
	}
}