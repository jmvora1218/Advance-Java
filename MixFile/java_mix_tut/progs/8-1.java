import java.util.*;
class Swap
{
	private String s1;
	private String s2;
	private String s3;
	Swap(String a,String b,String c)
	{
		s1=a;
		s2=b;
		s3=c;
	}	
	public void display()
	{
		System.out.println("String 1: "+s1+" String 2: "+s2+" String 3: "+s3);
	}
	public void swap1()
	{
		String a="";
		for(int i=0;i<s1.length();i++)
		{
			a=a+s1.charAt(i);
		}
		s1="";
		for(int i=0;i<s2.length();i++)
		{
			s1=s1+s2.charAt(i);
		}
		s2="";
		for(int i=0;i<s3.length();i++)
		{
			s2=s2+s3.charAt(i);
		}
		s3="";
		for(int i=0;i<a.length();i++)
		{
			s3=s3+a.charAt(i);
		}
	}
}

class Demo8
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter any three String: ");
		String a=sc.next();
		String b=sc.next();
		String c=sc.next();
		Swap s11=new Swap(a,b,c);
		System.out.print("Entered strings: ");
		s11.display();
		s11.swap1();
		System.out.print("Strings after swaping: ");
		s11.display();
	}
}