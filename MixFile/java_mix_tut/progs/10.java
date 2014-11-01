import java.util.*;
class Alphabet
{
	private char a;
	public void initialize(char y)
	{
		a=y;
	}
	public void display()
	{
		System.out.println("Entered Character is : "+a);
	}
	public int  digit()
	{
		if(a>='0' && a<='9')
			return 1;
		else
			return 0;	
	}
}
class Demo10
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter any Character  ");
		char a=(sc.next()).charAt(0);

		Alphabet al=new Alphabet();
		al.initialize(a);
		al.display();
		int b=al.digit();
		if(b==1)
			System.out.println("Enterd Character is Digit.");
		else
			System.out.println("Entered Character is not Digit.");
		
	}
}