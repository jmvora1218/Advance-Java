import java.util.*;
class Search
{
	private int a[];
	Search(int x[])
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
	public int searchCount(int x)
	{
		int temp=x,count=0;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]==temp)
				count++;
		}
		return count;
	}
}
class Demo5
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
		Search s1=new Search(b);
		s1.display();
		System.out.print("Enter the element that you want to search: ");
		int d=sc.nextInt();
		int c=s1.searchCount(d);
		System.out.println(d+" Found "+c+" times.");
	}
}