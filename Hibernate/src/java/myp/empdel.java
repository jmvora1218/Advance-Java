/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myp;

import java.util.Scanner;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author SHREEJI
 */
public class empdel {
    public static void main(String args[]){
        String un;
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session s=sf.openSession();
        Scanner sc=new Scanner(System.in);
        
        String hql="delete from Emp where name=:un";
        System.out.println("Enter user name: ");
        un=sc.next();
        
        Query q=s.createQuery(hql);
        q.setParameter("un",un);
        
        int r=q.executeUpdate();
        System.out.println("Record deleted. ");
        
    }
}
