package edu.acc.j2ee.capstone.model;
// Generated Jul 27, 2014 2:59:38 PM by Hibernate Tools 3.6.0


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Mat generated by hbm2java
 */
@Entity
@Table(name="MAT"
    ,schema="APP"
)
public class Mat  implements java.io.Serializable {


     private String matid;
     private String imagelink;
     private String name;

    public Mat() {
    }

    public Mat(String matid, String imagelink, String name) {
       this.matid = matid;
       this.imagelink = imagelink;
       this.name = name;
    }
   
     @Id 

    
    @Column(name="MATID", unique=true, nullable=false, length=15)
    public String getMatid() {
        return this.matid;
    }
    
    public void setMatid(String matid) {
        this.matid = matid;
    }

    
    @Column(name="IMAGELINK", nullable=false, length=25)
    public String getImagelink() {
        return this.imagelink;
    }
    
    public void setImagelink(String imagelink) {
        this.imagelink = imagelink;
    }

    
    @Column(name="NAME", nullable=false, length=20)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }




}


