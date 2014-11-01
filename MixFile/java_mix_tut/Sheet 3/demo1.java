import java.util.*;
class Max
{
	private int a[];
	Max(int x[])
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
}
class Demo1
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
		Max m2=new Max(b);
		m2.display();
		int c=m2.arrayMax();
		System.out.println("Max of  entered Array: "+c);
	}
}