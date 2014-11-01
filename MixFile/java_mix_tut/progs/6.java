import java.util.*;
class ProfitLoss
{
	private double sp,cp;
	public void initialize(double s,double c)
	{
		sp=s;
		cp=c;
	}
	public void display()
	{
		System.out.println("Selling Price: "+sp);
		System.out.println("Cost Price: "+cp);
	}
	public double perProfitLoss()
	{
		if(sp>cp)
		{
			double ans=(sp-cp)/cp*100;
			return ans;
		}
		else
		{
			double ans=(cp-sp)/cp*100;
			return ans;
		}
	}
}
class Demo6
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the Selling Price :  ");
		double a=sc.nextDouble();
		System.out.print("Enter the Cost Price: ");
		double b=sc.nextDouble();
		ProfitLoss pl=new ProfitLoss();
		pl.initialize(a,b);
		pl.display();
		double x=pl.perProfitLoss();
		if(a>b)
			System.out.println("Percentage of Profit = "+x+"%");
		else
			System.out.println("Percentage of Loss = "+x+"%");
	}
}