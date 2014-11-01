/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypk;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Tutorial {
    public static void main(String args[]){
        int id;
        String sd,ld,pu;
        Scanner sc=new Scanner(System.in);
        Configuration c=new Configuration();
        c=c.configure();
        SessionFactory sf=c.buildSessionFactory();
        Session s=sf.openSession();
       
        
        Person p=new Person();
       
        
        p.setName("jv");
        
        try{
            Transaction tx=s.beginTransaction();
            
            s.save(p);
            System.out.println("data inserted!!!");
            tx.commit();
        }catch(Exception e){
           System.out.println("err : "+ e.getMessage());
        }
    }
}