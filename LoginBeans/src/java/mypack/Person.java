/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypack;

/**
 *
 * @author SHREEJI
 */
public class Person {
    private String name;
    private String password;
    
    public Person(){ 
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    
    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return password;
    }
}