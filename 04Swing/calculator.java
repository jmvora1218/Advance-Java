import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

class calculator extends JFrame implements ActionListener
{
	JTextField tf;
	JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;
	JButton btnadd,btnsub,btnmul,btndiv,btneql;
	int ov,cvv;
	String op="";
	Container cp=null;
	public calculator(String title)
	{
		super(title);
		setSize(400,500);
		setVisible(true);
		cp=getContentPane();
		cp.setLayout(new FlowLayout());
		tf=new JTextField(25);
		btn1=new JButton("1");
		btn2=new JButton("2");
		btn3=new JButton("3");
		btn4=new JButton("4");
		btn5=new JButton("5");
		btn6=new JButton("6");
		btn7=new JButton("7");
		btn8=new JButton("8");
		btn9=new JButton("9");
		btn0=new JButton("0");
		btnadd=new JButton("+");
		btnsub=new JButton("-");
		btnmul=new JButton("*");
		btndiv=new JButton("/");
		btneql=new JButton("=");
		
		cp.add(tf);
		cp.add(btn1);
		cp.add(btn2);
		cp.add(btn3);
		cp.add(btn4);
		cp.add(btn5);
		cp.add(btn6);
		cp.add(btn7);
		cp.add(btn8);
		cp.add(btn9);
		cp.add(btn0);
		cp.add(btnadd);
		cp.add(btnsub);
		cp.add(btnmul);
		cp.add(btndiv);
		cp.add(btneql);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		btn0.addActionListener(this);
		btnadd.addActionListener(this);
		btnsub.addActionListener(this);
		btnmul.addActionListener(this);
		btndiv.addActionListener(this);
		btneql.addActionListener(this);
		
	}
		public void actionPerformed(ActionEvent ae)
		{
			String cv=(String)ae.getActionCommand();
			if(cv.equals("1"))
			{
				tf.setText(tf.getText()+"1");
			}
			if(cv.equals("2"))
			{
				tf.setText(tf.getText()+"2");
			}
			if(cv.equals("3"))
			{
				tf.setText(tf.getText()+"3");
			}
			if(cv.equals("4"))
			{
				tf.setText(tf.getText()+"4");
			}
			if(cv.equals("5"))
			{
				tf.setText(tf.getText()+"5");
			}
			if(cv.equals("6"))
			{
				tf.setText(tf.getText()+"6");
			}
			if(cv.equals("7"))
			{
				tf.setText(tf.getText()+"7");
			}
			if(cv.equals("8"))
			{
				tf.setText(tf.getText()+"8");
			}
			if(cv.equals("9"))
			{
				tf.setText(tf.getText()+"9");
			}
			if(cv.equals("0"))
			{
				tf.setText(tf.getText()+"0");
			}
			if(cv.equals("+"))
			{
				ov=Integer.parseInt(tf.getText());
				tf.setText("");
				op="+";
			}
			if(cv.equals("-"))
			{
				ov=Integer.parseInt(tf.getText());
				tf.setText("");
				op="-";
			}
			if(cv.equals("*"))
			{
				ov=Integer.parseInt(tf.getText());
				tf.setText("");
				op="*";
			}
			if(cv.equals("/"))
			{
				ov=Integer.parseInt(tf.getText());
				tf.setText("");
				op="/";
			}
			if(cv.equals("="))
			{
				cvv=Integer.parseInt(tf.getText());
				if(op.equals("+"))
				{
					int ans=ov+cvv;
					tf.setText(ans+"");
				}
				if(op.equals("-"))
				{
					int ans=ov-cvv;
					tf.setText(ans+"");
				}
				if(op.equals("*"))
				{
					int ans=ov*cvv;
					tf.setText(ans+"");
				}
				if(op.equals("/"))
				{
					int ans=ov/cvv;
					tf.setText(ans+"");
				}
			}
		}
		public static void main(String args[])
		{
			calculator cal=new calculator("calc");
		
		}
}