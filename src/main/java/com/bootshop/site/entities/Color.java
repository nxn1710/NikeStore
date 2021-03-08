package com.bootshop.site.entities;
// Generated Mar 5, 2021 10:34:32 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Color generated by hbm2java
 */
@Entity
@Table(name="color")
public class Color  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

     private int id;
     private String value;
     private Set<Product> products = new HashSet<Product>(0);

    public Color() {
    }

	
    public Color(int id, String value) {
        this.id = id;
        this.value = value;
    }
    public Color(int id, String value, Set<Product> products) {
       this.id = id;
       this.value = value;
       this.products = products;
    }
   
     @Id 
     @GeneratedValue(strategy = GenerationType.IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="value", nullable=false)
    public String getValue() {
        return this.value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="color")
    public Set<Product> getProducts() {
        return this.products;
    }
    
    public void setProducts(Set<Product> products) {
        this.products = products;
    }




}

