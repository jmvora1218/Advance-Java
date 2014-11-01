import java.util.*;
class Name
{
	private String s[];
	public void initialize(String a[])
	{
		s=a;
	}
	void display()
	{
		System.out.print("Entered strings in string array: ");
		for(int i=0;i<s.length;i++)
		{
			System.out.println(s[i]);
		}
	}
	boolean search(String a)
	{
		int k=0,count=0;
		for(int i=0;i<s.length;i++)
		{
			k=0;
			for(int j=0;j<s[i].length();j++)
			{
				if(a.charAt(k)==s[i].charAt(j))
				{
					k++;
					count=1;
				}
				else
				{
					break;
				}
			}
		}
		if(count==1)
			return true;
		else 
			return false;
	}
	void charA()
	{
		for(int i=0;i<s.length;i++)
		{
			if(s[i].charAt(0)=='A')
			{
				System.out.println(s[i]);
			}
		}
	}
	int charr()
	{
		int count=0;
		for(int i=0;i<s.length;i++)
		{
			for(int j=0;j<s[i].length();j++)
			{
				if(s[i].charAt(j)>=65 && s[i].charAt(j)<=98)  								{
					count++;
				}
				if(s[i].charAt(j)>=97 && s[i].charAt(j)<=122)
				{
					count++;
				}

			}
		}
		return count;
	}	
}
class Demo13
{
	public static void main(String arg[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the length of string array: ");
		int n=sc.nextInt();
		String a[]=new String[n];	
		System.out.println("Enter the strings: ");
		for(int i=0;i<a.length;i++)
		{
			a[i]=sc.next();
		}
		Name n1=new Name();
		n1.initialize(a);
		n1.display();
		System.out.print("Enter the string that you want to search: ");
		String b=sc.next();
		boolean c=n1.search(b);
		if(c==true)
			System.out.println("String found.");
		else 
			System.out.println("String not found.");
		n1.charA();
		int d=n1.charr();
		System.out.println("No of character in array: "+d);
	}
}