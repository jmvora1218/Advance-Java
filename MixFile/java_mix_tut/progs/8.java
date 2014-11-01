import java.util.*;
class Digit
{
	private int num;
	public void initialize(int n)
	{
		num=n;
	}
	public void display()
	{
		System.out.println("Entered number is : "+num);
	}
	public int noDigit()
	{
		int count=0,n=num;
		while(n>0)
		{
			n=n/10;
			count++;
		}
		return count;
	}
	public int noSum()
	{
		int sum=0,n=num;
		while(n>0)
		{
			sum=sum+(n%10);
			n=n/10;
		}
		return sum;	
	}
	public int noReverse()
	{
		int rev=0,c,n=num;
		while(n>0)
		{
			c=n%10;
			rev=(rev*10)+c;
			n=n/10;
		}
		return rev;	
	}
	public int noArmstrong()
	{
		int sum=0,c,n=num;
		while(n>0)
		{
			c=n%10;
			sum=sum+(c^3);
			n=n/10;	
		}
		if(sum==num)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	public int noPelindrom()
	{
		int temp=noReverse();
		if(temp==num)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	public int noPerfect()
	{
		int c=0,c1=1,n=num,a;
		while(n>0)
		{
			a=num%10;
			c=c+a;
			c1=c1*a;
			n=n/10;	
		}
		if(c==c1)
			return 1;
		else
			return 0;
	}
}
class Demo8
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter any Integer no:  ");
		int a=sc.nextInt();
		Digit d=new Digit();
		d.initialize(a);
		d.display();
		int b=d.noDigit();
		System.out.println("No of Digit in entered no is: "+b);
		int c=d.noSum();
		System.out.println("Sum of all digit of entered no is: "+c);
		int e=d.noReverse();
		System.out.println("Reveres of Entered no is: "+e);
		int f=d.noArmstrong();
		if(f==1)
			System.out.println("Entered no is armstrong.");
		else
			System.out.println("Entered no is not armstrong.");
		int g=d.noPelindrom();
		if(g==1)
			System.out.println("Entered no is pelindrom.");
		else
			System.out.println("Entered no is not pelindrom.");
		int h=d.noPerfect();
		if(h==1)
			System.out.println("Entered no is Perfect. ");
		else
			System.out.println("Entered no is not perfect. ");


		
	}
}