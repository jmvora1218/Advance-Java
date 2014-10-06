import javax.swing.*;
import java.awt.*;
class btnjframe extends JFrame
{
	JButton b1,b2;
	Container cp=null;
	public btnjframe(String title)
	{
		super(title);
		setSize(200,300);
		setVisible(true);
		cp=getContentPane();
		cp.setLayout(null);
		b1=new JButton("b1");
		b1.setBounds(20,10,30,15);
		cp.add(b1);
		
		b2=new JButton("b2");
		b2=setBounds(50,10,30,15);
		cp.add(b2);
	}
	public static void main(String args[])
	{
		btnjframe btn=new btnjframe("button");
	}
}