import java.util.*;
class Time
{
	private int hh,mm;
	public void initialize(int h,int m)
	{
		if(m>60)
		{
			hh=h+(m/60);
			mm=m%60;
		}
		else
		{
			hh=h;
			mm=m;
		}
		
	}
	public void display()
	{
		System.out.println("HH:MM "+hh+":"+mm);
	}
	public int timeMinutes()
	{
		int m=(hh*60)+mm;
		return m;
	}
	public double timeHours()
	{
		double x;
		x=hh+(double)(mm/60);
		return x;
	}	
}
class Demo4
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the hours:  ");
		int h=sc.nextInt();
		System.out.print("Enter the Minutes: ");
		int m=sc.nextInt();
		Time t=new Time();
		t.initialize(h,m);
		t.display();
		int a=t.timeMinutes();
		double b=t.timeHours();
		System.out.println("Time in Minutes: "+a);
		System.out.print("Time in Hours: "+b);
	}
}