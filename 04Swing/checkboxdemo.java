import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

class checkboxdemo extends JFrame implements ActionListener
{
	JLabel lbl;
	JCheckBox jch,jcf,jcc;
	String msg="";
	Container cp=null;
	
	public checkboxdemo(String title)
	{
		super(title);
		setSize(200,300);
		setVisible(true);
		cp=getContentPane();
		cp.setLayout(new FlowLayout());
		
		lbl=new JLabel("Hobbies");
		jch=new JCheckBox("Hocky");
		jcf=new JCheckBox("football");
		jcc=new JCheckBox("cricket");
		
		cp.add(lbl);
		cp.add(jch);
		cp.add(jcf);
		cp.add(jcc);
		
		jch.addActionListener(this);
		jcf.addActionListener(this);
		jcc.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		msg=" Hobbies is:";
		if(jch.isSelected())
		{
			msg=msg+jch.getText();
		}
		if(jcf.isSelected())
		{
			msg=msg+jcf.getText();
		}
		if(jcc.isSelected())
		{
			msg=msg+jcc.getText();
		}
		JOptionPane.showMessageDialog(this,msg);
	}
	public static void main(String args[])
	{
		checkboxdemo chk=new checkboxdemo("box");
	}
}