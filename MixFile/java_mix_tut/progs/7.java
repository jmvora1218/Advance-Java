import java.util.*;
class Bank
{
	private long acc_id;
	private double bal;
	public void initialize(long a,double b)
	{
		acc_id=a;
		bal=b;
	}
	public void display()
	{
		System.out.println("Account ID: "+acc_id);
		System.out.println("Balnce: "+bal);
	}
	public void deposite(double a)
	{
		bal=bal+a;
		System.out.println("Transaction done succesfully.");
		System.out.println("Balnce after last transaction: "+bal);
	}
	public void withdraw(double a)
	{
		if(a>bal)
		{
			System.out.println("You don't have enough account balance to withdraw entered amount.");
			System.out.println("Account Balance: "+bal);
		}
		else
		{
			bal=bal-a;
			System.out.println("Transaction done succesfully.");
			System.out.println("Account Balance: "+bal);
		}
	}
}
class Demo7
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the Accound Id :  ");
		long a=sc.nextLong();
		System.out.print("Enter the Account Balance: ");
		double b=sc.nextDouble();
		Bank b1=new Bank();
		b1.initialize(a,b);
		b1.display();
		System.out.print("Enter the amount you want to deposite: ");
		double c=sc.nextDouble();
		b1.deposite(c);
		System.out.println("Enter the amount you want to withdraw: ");
		double d=sc.nextDouble();
		b1.withdraw(d);
	}
}