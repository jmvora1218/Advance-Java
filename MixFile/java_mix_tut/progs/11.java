import java.util.*;
class Average
{
	private int a[];
	public void initialize(int x[])
	{		
		a=x;	
	}
	public void display()
	{
		System.out.print("Entered array elements are:  ");
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	public float arrayAvg()
	{
		int sum=0;
		for(int i=0;i<a.length;i++)
		{
			sum=sum+a[i];
		}
		float avg=sum/a.length;
		return avg;
	}
	public int arraySearch(int n)
	{
		int count =0;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]==n)
			{
				count=1;
				break;
			}
		}
		if(count==0)
			return 1;
		else
			return 0;
	}

	public float arrayAvgMaxMin()
	{
		int max=a[0],min=a[0];
		for(int i=0;i<a.length;i++)
		{
			if(max<a[i])
			{
				max=a[i];
			}
			if(min>a[i])
			{
				min=a[i];
			}
		}
		float avg=(min+max)/2;
		return avg;
	}
}
class Demo11
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the length of array: ");
		int a=sc.nextInt();
		int b[]=new int[a];
		for(int i=0;i<b.length;i++)
		{
			System.out.print("Enter the element   : ");
			b[i]=sc.nextInt();
			System.out.println();
		}
		Average a1=new Average();
		a1.initialize(b);
		a1.display();
		float c=a1.arrayAvg();
		System.out.println("Average of all array elements : "+c);
		System.out.print("Enter the element that you want to search in array: ");
		int d=sc.nextInt();
		int e=a1.arraySearch(d);
		if(e==1)
			System.out.println("Element not found.");
		else
			System.out.println("Element found.");
		float f=a1.arrayAvgMaxMin();
		System.out.println("Average of min & max of entered Array : "+f);
	}
}