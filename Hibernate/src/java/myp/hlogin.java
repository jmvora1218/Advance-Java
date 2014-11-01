/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myp;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author SHREEJI
 */
public class hlogin {
    
  public static void main(String args[]){
      String un,up;
      SessionFactory sf=new Configuration().configure().buildSessionFactory();
      Session s=sf.openSession();
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter user name: ");
      un=sc.next();
      System.out.println("Enter Password: ");
      up=sc.next();
      
      Emp le=(Emp)s.get(Emp.class,un);
      if(le!=null){
          if(le.getUp().equals(up))
          {
            System.out.println("Wel-come");
          }
          else
          {
            System.out.println("Mismatch");
          }
      }
          else
          {
            System.out.println("Na");
          } 
  }
}
