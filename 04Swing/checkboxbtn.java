import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

class checkboxbtn extends JFrame implements ActionListener
{
	JLabel lbl;
	JCheckBox jch,jcf,jcc;
	JButton btn;
	String msg="";
	Container cp=null;
	
	public checkboxbtn(String title)
	{
		super(title);
		setSize(200,300);
		setVisible(true);
		cp=getContentPane();
		cp.setLayout(new FlowLayout());
		
		lbl=new JLabel("Hobbies: ");
		jch=new JCheckBox("Hocky");
		jcf=new JCheckBox("football");
		jcc=new JCheckBox("cricket");
		btn=new JButton("submit");
	
		cp.add(lbl);
		cp.add(jch);
		cp.add(jcf);
		cp.add(jcc);
		cp.add(btn);
		
		btn.addActionListener(this);

	}
	public void actionPerformed(ActionEvent ae)
	{
		msg=" Hobbies is: ";
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
		checkboxbtn chk=new checkboxbtn("box");
	}
}