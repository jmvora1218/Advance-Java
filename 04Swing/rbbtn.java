import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

class rbbtn extends JFrame implements ActionListener
{
	JLabel lbl;
	JRadioButton rbm,rbf;
	String msg="";
	Container cp=null;
	ButtonGroup bg;
	JButton btn;
	
	public rbbtn(String title)
	{
		super(title);
		setSize(400,400);
		setVisible(true);
		cp=getContentPane();
		cp.setLayout(new FlowLayout());
		
		lbl=new JLabel("Gender");
		rbm=new JRadioButton("Male");
		rbf=new JRadioButton("Female");
		bg=new ButtonGroup();
		btn=new JButton("submit");
		
		cp.add(lbl);
		cp.add(rbm);
		cp.add(rbf);
		bg.add(rbm);
		bg.add(rbf);
		cp.add(btn);
		
		btn.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		msg=" you are:";
		if(rbm.isSelected())
		{
			msg=msg+rbm.getText();
		}
		if(rbf.isSelected())
		{
			msg=msg+rbf.getText();
		}
		JOptionPane.showMessageDialog(this,msg);
	}
	public static void main(String args[])
	{
		rbbtn rb=new rbbtn("box");
	}
}