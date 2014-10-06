import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

class cbdemo extends JFrame implements ActionListener
{
	JLabel lbl;
	JComboBox jcb;
	String msg="";
	Container cp=null;
	ButtonGroup bg;
	JButton btn;
	
	public cbdemo(String title)
	{
		super(title);
		setSize(400,400);
		setVisible(true);
		cp=getContentPane();
		cp.setLayout(new FlowLayout());
		
		lbl=new JLabel("city");
		String d[]={"Baroda","Rajkot","Surat"};
		jcb=new JComboBox(d);
		btn=new JButton("Submit");
		
		cp.add(lbl);
		cp.add(jcb);
		cp.add(btn);
	
		btn.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		msg=" you are from:";
		String d=(String)jcb.getSelectedItem();
			msg=msg+"=="+d;
		JOptionPane.showMessageDialog(this,msg);
	}
	public static void main(String args[])
	{
		cbdemo cb=new cbdemo("box");
	}
}