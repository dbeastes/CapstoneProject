package edu.acc.j2ee.capstone.model;
// Generated Jul 27, 2014 2:59:38 PM by Hibernate Tools 3.6.0


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Customer generated by hbm2java
 */
@Entity
@Table(name="CUSTOMER"
    ,schema="APP"
)
public class Customer  implements java.io.Serializable {


     private int id;
     private String fname;
     private String lname;
     private String email;
     private String username;
     private String password;

    public Customer() {
    }

	
    public Customer(int id, String fname, String lname, String email) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }
    public Customer(int id, String fname, String lname, String email, String username, String password) {
       this.id = id;
       this.fname = fname;
       this.lname = lname;
       this.email = email;
       this.username = username;
       this.password = password;
    }
   
     @Id 

    
    @Column(name="ID", unique=true, nullable=false, precision=5, scale=0)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="FNAME", nullable=false, length=20)
    public String getFname() {
        return this.fname;
    }
    
    public void setFname(String fname) {
        this.fname = fname;
    }

    
    @Column(name="LNAME", nullable=false, length=20)
    public String getLname() {
        return this.lname;
    }
    
    public void setLname(String lname) {
        this.lname = lname;
    }

    
    @Column(name="EMAIL", nullable=false, length=30)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="USERNAME", length=25)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    
    @Column(name="PASSWORD", length=25)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }




}


