import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

class form extends JFrame implements ActionListener
{
	JTextField tf;
	JLabel lbltf,lblcb,lblr,lblcombo;
	JCheckBox jch,jcf,jcc;
	JRadioButton rbm,rbf;
	JComboBox jcb;
	JButton btns;
	ButtonGroup bg;
	String msg="";
	Container cp=null;
	
	public form(String title)
	{
		super(title);
		setSize(200,300);
		setVisible(true);
		cp=getContentPane();
		cp.setLayout(new FlowLayout());
		
		tf=new JTextField(50);
		lbltf=new JLabel("Name");
		cp.add(lbltf);
		cp.add(tf);
		
		lblcb=new JLabel("Hobbies");
		jch=new JCheckBox("Hocky");
		jcf=new JCheckBox("football");
		jcc=new JCheckBox("cricket");
		cp.add(jch);
		cp.add(jcf);
		cp.add(jcc);
		
		lblr=new JLabel("Gender");
		rbm=new JRadioButton("Male");
		rbf=new JRadioButton("Female");
		bg=new ButtonGroup();
		cp.add(lblr);
		cp.add(rbm);
		cp.add(rbf);
		bg.add(rbm);
		bg.add(rbf);
		
		lblcombo=new JLabel("city");
		String d[]={"Baroda","Rajkot","Surat"};
		jcb=new JComboBox(d);
		btns=new JButton("Submit");
		cp.add(lblcombo);
		cp.add(jcb);
		
		btns=new JButton("Submit");
		cp.add(btns);
		btns.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		msg=" Your Selected item is:- ";
		
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
		if(rbm.isSelected())
		{
			msg=msg+rbm.getText();
		}
		if(rbf.isSelected())
		{
			msg=msg+rbf.getText();
		}
		String d=(String)jcb.getSelectedItem();
		msg=msg+"="+d;
		JOptionPane.showMessageDialog(this,msg);
	}
	public static void main(String args[])
	{
		form fm=new form("detail");
	}
}