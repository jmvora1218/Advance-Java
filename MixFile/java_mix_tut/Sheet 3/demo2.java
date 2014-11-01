import java.util.*;
class Min
{
	private int a[];
	Min(int x[])
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
	
}
class Demo2
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
		Min m2=new Min(b);
		m2.display();
		
		int c=m2.arrayMin();
		System.out.println("Min of  entered Array: "+c);
	}
}