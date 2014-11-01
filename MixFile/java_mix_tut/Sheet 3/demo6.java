import java.util.*;
class High
{
	private int a[];
	High(int x[])
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
	public void Highest()
	{
		int temp=0;
		for(int i=0;i<a.length-1;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
				if(a[j]>a[i])
				{
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}	
			}
		}
		for(int i=0;i<3;i++)
		{
			System.out.print(" "+a[i]);
		}	
	}
}
class Demo6
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
		High h1=new High(b);
		h1.display();
		h1.Highest();
	}
}