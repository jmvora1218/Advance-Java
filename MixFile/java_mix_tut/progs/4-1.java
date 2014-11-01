import java.util.*;
class Array
{
	private int a[],b[],c[],d[];
	Array(int x[])
	{
		a=x;
	}
	public void display(int x[])
	{
		for(int i=0;i<x.length;i++)
		{
			System.out.print(x[i]+" ");
		}
		System.out.println();
	}
	public void arryB()
	{
		int x[]=new int[a.length];
		for(int i=0;i<a.length;i++)
		{
			x[i]=2*a[i];
		}
		b=x;
	}
	public void arryC()
	{
		int x[]=new int[a.length];
		int k=0;
		for(int i=a.length-1;i>=0;i--)
		{
			x[k]=a[i];
			k++;
		}
		c=x;
	}
	public void arryD()
	{
		int x[]=new int[a.length];
		for(int i=0;i<a.length;i++)
		{
			x[i]=a[i]+b[i]+c[i];
		}
		d=x;
	}
	public void printArry()
	{
		System.out.print("Elements of array A: ");
		display(a);
		System.out.print("Elements of array B: ");
		display(b);
		System.out.print("Elements of array C: ");
		display(c);
		System.out.print("Elements of array D: ");
		display(d);
	} 
}
class Demo4
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
		Array a1=new Array(b);
		a1.arryB();
		a1.arryC();
		a1.arryD();
		a1.printArry();
	}
}