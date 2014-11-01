/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author SHREEJI
 */

public class printrec {
    public static void main(String args[]){
        int id=5;
        //String sd,ld,pu;
        //Configuration c=new Configuration();
       // c=c.configure();
        //SessionFactory sf=c.buildSessionFactory();
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session s=sf.openSession();
        System.out.println("25");
        try{
            System.out.println("27");
            Tutorial t=(Tutorial)s.get(Tutorial.class,id);
            System.out.println(t.getSortdes()+"  "+t.getLongdes()+"  "+t.getPageurl());
        }catch(Exception e){
            System.out.println("err : " +e.getMessage());
        }
    }
}