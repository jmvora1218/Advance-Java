package myp;


import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SHREEJI
 */
public class insert {
    public static void main(String args[]){
        int id;
        String sd,ld,pu;
        Scanner sc=new Scanner(System.in);
        Configuration c=new Configuration();
        c=c.configure();
        SessionFactory sf=c.buildSessionFactory();
        Session s=sf.openSession();
        
        System.out.println("Enter id: ");
        id=sc.nextInt();
        System.out.println("Enter Sort Detail: ");
        sd=sc.next();
        System.out.println("Enter the Long detail: ");
        ld=sc.next();
        System.out.println("Enter the page URL: ");
        pu=sc.next();
        
        Tutorial t=new Tutorial();
        t.setId(id);
        t.setSortdes(sd);
        t.setLongdes(ld);
        t.setPageurl(pu);
        
        try{
            Transaction tx=s.beginTransaction();
            s.save(t);
            tx.commit();
            System.out.println("Data inserted in Table.");
        }catch(Exception e){
            System.out.println("err : "+e.getMessage());
        }
    }
}