import java.util.*;
class MaxMin
{
	private int a[];
	MaxMin(int x[])
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
	public int arrayMin()
	{
		int min=a[0];
		for(int i=0;i<a.length;i++)
		{
			if(min>a[i])
			{
				min=a[i];
			}
		}
		return min;
	}
	public int arrayMax()
	{
		int max=a[0];
		for(int i=0;i<a.length;i++)
		{
			if(max<a[i])
			{
				max=a[i];
			}
		}
		return max;
	}
	public int maxMinfact()
	{
		int max=arrayMax();
		int min=arrayMin();
		int fact1=1,fact2=1;
		for(int i=1;i<=min;i++)
		{
			fact1=fact1*i;
		}
		for(int i=1;i<=max;i++)
		{
			fact2=fact2*i;
		}
		return (fact1+fact2);
	}
	public int maxPowMin()
	{
		int max=arrayMax();
		int min=arrayMin();
		int temp=1;
		for(int i=1;i<=min;i++)
		{
			temp=temp*max;
		}
		return temp;
	}
	public float avgMinMax()
	{
		int max=arrayMax();
		int min=arrayMin();
		float avg=(max+min)/2;
		return avg;
	}
}
class Demo3
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
		MaxMin m1=new MaxMin(b);
		m1.display();
		int c=m1.maxMinfact();
		System.out.println("max! + min! = "+c);
		int d=m1.maxPowMin();
		System.out.println("max^min: "+d);
		float e=m1.avgMinMax();
		System.out.println("Average of max & min: "+e);
	}
}