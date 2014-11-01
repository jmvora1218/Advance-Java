package mypk;
// Generated Oct 31, 2014 2:05:23 PM by Hibernate Tools 4.3.1

public class Person  implements java.io.Serializable {


     private Integer id;
     private String name;

    public Person() {
    }

    public Person(String name) {
       this.name = name;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}


