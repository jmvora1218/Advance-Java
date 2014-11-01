import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/* <applet code="CardDemo" width="400" height="400">
</applet>
*/
public  class CardDemo extends JApplet implements ActionListener
{
	JButton b1,b2,b3,b4;
	JPanel cardp,btnp,p1,p2,p3,p4;
	JLabel l1,l2,l3,l4;
	Container cp=null;
	CardLayout cl=new CardLayout();
	public void init()
	{
		cp=getContentPane();
		cp.setLayout(new BorderLayout());
		cardp=new JPanel();
		cardp.setLayout(cl);
		btnp=new JPanel(new FlowLayout());
		p1=new JPanel(new BorderLayout());
		p2=new JPanel(new BorderLayout());
		p3=new JPanel(new BorderLayout());
		p4=new JPanel(new BorderLayout());
		b1=new JButton("B1");
		b2=new JButton("B2");
		b3=new JButton("B3");
		b4=new JButton("B4");
		l1=new JLabel("a");
		l2=new JLabel("b");
		l3=new JLabel("c");
		l4=new JLabel("d");
		p1.add(l1);
		p2.add(l2);
		p3.add(l3);
		p4.add(l4);
		cardp.add(p1,"1");
		cardp.add(p2,"2");
		cardp.add(p3,"3");
		cardp.add(p4,"4");
		btnp.add(b1);
		btnp.add(b2);
		btnp.add(b3);
		btnp.add(b4);
		cp.add(cardp,BorderLayout.NORTH);
		cp.add(btnp,BorderLayout.SOUTH);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}
	public void actionPerformed(ActionEvent a)
	{
		
		String lv=(String)a.getActionCommand();
		if(lv.equals("B1"))
		{
			cl.show(cardp,"1");
		}
		if(lv.equals("B2"))
		{
			cl.show(cardp,"2");
		}
		if(lv.equals("B3"))
		{
			cl.show(cardp,"3");
		}
		if(lv.equals("B4"))
		{
			cl.show(cardp,"4");
		}
	}
}