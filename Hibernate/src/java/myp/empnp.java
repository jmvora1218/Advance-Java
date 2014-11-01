/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myp;

import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.*;

/**
 *
 * @author SHREEJI
 */
public class empnp {
    public static void main(String args[]){
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session s=sf.openSession();
        
        Query q=s.createQuery("from Emp");
        List l=q.list();
        int len=l.size();
        for(int i=0;i<len;i++){
            Emp e=(Emp)l.get(i);
            System.out.println(e.getUn()+"  "+e.getUp());
        }
     }  
}
