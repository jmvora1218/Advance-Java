import java.util.*;
class Plain
{
	private String a;
	public void initialize(String s)
	{
		a=s;
	}
	public void display()
	{
		System.out.println("Entered string: "+a);
	}
	public String reverse()
	{
		String b="";
		for(int i=a.length()-1;i>=0;i--)
		{
			b=b+a.charAt(i);
		}
		return b;	
	}
	public boolean pelindrom()
	{
		String c=reverse();
		int count=0;
		for(int i=0;i<a.length();i++)
		{
			if(a.charAt(i)==c.charAt(i))
				count=0;
			else
			{
				count=1;
				break;
			}
		}
		if(count==0)
			return true;
		else
			return false;
	}
}
class Demo12
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String a;
		System.out.print("Enter the String: ");
		a=sc.next();
		Plain p1=new Plain();	
		p1.initialize(a);
		p1.display();
		String b=p1.reverse();
		System.out.println("Reverse of entered String: "+b);
		boolean c=p1.pelindrom();
		System.out.println(c);
		if(c==true)
			System.out.println("Entered string is pelindrom.");
		else
			System.out.println("Entered String is not pelindrom.");
	}
}
	