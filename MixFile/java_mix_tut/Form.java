import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/* <applet code="Form" width="400" height="400">
   </applet>
*/

public class Form extends JApplet implements ActionListener
{
	JPanel p1,p2,p3,p4,p5,p6,mp;
	Label lbn;
	TextField tfn;
	JLabel lbh,lbg,lbc,lbf;
	JCheckBox cbc,cbf,cbh;
	JRadioButton rbm,rbf;
	JComboBox jcb;
	JList jl;
	String d[]={"select food","Gujrati","Punjabi","Chinise"};
	JButton b1;
	Container cp=null;
	ButtonGroup bg=null;
	String msg="",name="",hobb="",gen="",city="",food="";
	public void init()
	{
		p1=new JPanel();
		p1.setLayout(new FlowLayout());//p1.setLayout(new GridLayout(1,2));
		p2=new JPanel();
		p2.setLayout(new FlowLayout());;//p2.setLayout(new GridLayout(1,4));
		p3=new JPanel();
		p3.setLayout(new FlowLayout());;//p3.setLayout(new GridLayout(1,3));
		p4=new JPanel();
		p4.setLayout(new FlowLayout());;//p4.setLayout(new GridLayout(1,2));
		p5=new JPanel();
		p5.setLayout(new FlowLayout());;//p5.setLayout(new GridLayout(1,2));
		p6=new JPanel();
		p6.setLayout(new FlowLayout());//p6.setLayout(new GridLayout(1,1));
		mp=new JPanel();
		mp.setLayout(new GridLayout(6,1));
		cp=getContentPane();
		//cp.setLayout(new FlowLayout());
		lbn=new Label("Name");
		tfn=new TextField();
		lbh=new JLabel("Hobbies");
		cbc=new JCheckBox("cricket");
		cbf=new JCheckBox("football");
		cbh=new JCheckBox("hockey");
		lbg=new JLabel("Gender");
		rbm=new JRadioButton("male");
		rbf=new JRadioButton("female");
		bg=new ButtonGroup();
		jcb=new JComboBox();
		lbf=new JLabel("Food");
		jcb.addItem("plz selected City");
		jcb.addItem("Rajkot");
		jcb.addItem("Banglur");
		jcb.addItem("Baroda");
		lbc=new JLabel("City");
		jl=new JList(d);
		jl.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		b1=new JButton("Submit");
		p1.add(lbn);
		p1.add(tfn);
		p2.add(lbh);
		p2.add(cbc);
		p2.add(cbf);
		p2.add(cbh);
		p3.add(lbg);
		p3.add(rbm);
		p3.add(rbf);
		p4.add(lbc);
		p4.add(jcb);
		p5.add(lbf);
		p5.add(jl);
		p6.add(b1);
		mp.add(p1);
		mp.add(p2);
		mp.add(p3);
		mp.add(p4);
		mp.add(p5);
		mp.add(p6);
		cp.add(mp);
		
		
		b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		name=tfn.getText();
		//JOptionPane.showMessageDialog(this,name);
		if(cbc.isSelected())
		{
			hobb=hobb+cbc.getLabel();
		}
		if(cbf.isSelected())
		{
			hobb=hobb+cbf.getLabel();
		}
		if(cbh.isSelected())
		{
			hobb=hobb+cbh.getLabel();
		}
		//JOptionPane.showMessageDialog(this,hobb);
		if(rbm.isSelected())
		{
			gen=rbm.getLabel();
		}
		if(rbf.isSelected())
		{
			gen=rbf.getLabel();
		}
		//JOptionPane.showMessageDialog(this,gen);
		
		city=(String)jcb.getSelectedItem();
		
		//JOptionPane.showMessageDialog(this,city);
		
		Object d[]=jl.getSelectedValues();
		for(int i=0;i<d.length;i++)
		{
			food=food+(String)d[i];
		}
		//JOptionPane.showMessageDialog(this,food);
		msg="Name="+name+ "hobbey="+hobb+ "Gender="+gen+ "City="+city+ "Food="+food;
		JOptionPane.showMessageDialog(this,msg);
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		