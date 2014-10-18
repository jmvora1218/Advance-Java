/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
/**
 *
 * @author SHREEJI
 */


public class pr2 extends JFrame implements ActionListener {
	JTextField tf1,tf2,answer;
        JLabel blank;
	JLabel lbltf1,lbltf2,lblr1,lblr2,lblcb,lblcombo1,lblcombo2,lblcombo3;
	JCheckBox jch,jcl;
	JRadioButton rby1,rbn1,rby2,rbn2;
	JComboBox jcb1,jcb2,jcb3;
	JButton btns;
	ButtonGroup bg1,bg2;
	String msg="";
	Container cp=null;
        GridLayout gl;
        
	
	public pr2(String title) 	{
		super(title);
                gl= new GridLayout(0,2,2,2);
                blank = new JLabel("");
                answer = new JTextField("");
		setSize(200,300);
		setVisible(true);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
		cp=getContentPane();
              
		cp.setLayout(gl); 
                
                tf1=new JTextField(50);
		lbltf1=new JLabel("Name");
		cp.add(lbltf1);
		cp.add(tf1);
                
                tf2=new JTextField(12);
		lbltf2=new JLabel("EnrollmentNo");
		cp.add(lbltf2);
		cp.add(tf2);
                lblr1=new JLabel("Hostel");
                cp.add(blank);
		rby1=new JRadioButton("Yes");
		rbn1=new JRadioButton("No");
		bg1=new ButtonGroup();
		cp.add(lblr1);
                
		cp.add(rby1);
		cp.add(rbn1);
		bg1.add(rby1);
		bg1.add(rbn1);
                
                lblr2=new JLabel("Transport");
                cp.add(blank);
		rby2=new JRadioButton("Yes");
		rbn2=new JRadioButton("No");
		bg2=new ButtonGroup();
		cp.add(lblr2);
		cp.add(rby2);
		cp.add(rbn2);
		bg2.add(rby2);
		bg2.add(rbn2);
                
                lblcb=new JLabel("Club");
		jch=new JCheckBox("Health");
		jcl=new JCheckBox("Library");
		cp.add(jch);
		cp.add(jcl);
                
                lblcombo1=new JLabel("College");
		String d[]={"PIET","PIT","L.D."};
		jcb1=new JComboBox(d);
                cp.add(lblcombo1);
		cp.add(jcb1);
                
		lblcombo2=new JLabel("Branch");
		String f[]={"CSE","IT","EC","Mech.","Civil"};
		jcb2=new JComboBox(f);
                cp.add(lblcombo2);
		cp.add(jcb2);
                
                lblcombo3=new JLabel("Sbject");
		String s[]={"AJT","CD","SC","ERP","WCMP"};
		jcb3=new JComboBox(s);
                cp.add(lblcombo3);
		cp.add(jcb3);
                
                btns=new JButton("Submit");
		cp.add(btns);
		btns.addActionListener(this);
                
                cp.add(answer);
		
        }
        
        public static void main(String args[]) { 
            JFrame hello = new pr2("hello app");
            
        }

    public void actionPerformed(ActionEvent e) {
        msg=" Your Selected item is:- ";
        msg+=("Name : "+tf1.getText()+"\n");
        msg+=("Enrollment : "+tf2.getText()+"\n");
        //msg+=("Name : "+tf1.getText()+"\n");
        answer.setText(msg);
        cp.add(answer);
    }
}
