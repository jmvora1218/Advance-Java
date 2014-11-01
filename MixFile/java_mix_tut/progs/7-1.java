import java.util.*;
class Strings
{
	private String s;
	Strings(String a)
	{
		s=a;
	}	
	public void display()
	{
		System.out.println("Entered String: "+s);
	}
	public int noAlphabate()
	{
		int count=0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)>='a' && s.charAt(i)<='z')
				count++;
			if(s.charAt(i)>='A' && s.charAt(i)<='Z')
				count++;
		}
		return count;
	}
	public int noVovels()
	{
		int count=0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u' || s.charAt(i)=='A' || s.charAt(i)=='E' || s.charAt(i)=='I' || s.charAt(i)=='O' || s.charAt(i)=='U')
			count++;
		}
		return count;
	}
	public void reverse()
	{
		String a="";
		for(int i=s.length()-1;i>=0;i--)
		{
			System.out.print(s.charAt(i));
		}
	}	
}

class Demo7
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Emter the String: ");
		String a=sc.next();
		Strings s1=new Strings(a);
		s1.display();
		int b=s1.noAlphabate();
		System.out.println("No of characters in the string array: "+b);
		int c=s1.noVovels();
		System.out.println("No of vovels in the strings: "+c);
		s1.reverse();
	}
}