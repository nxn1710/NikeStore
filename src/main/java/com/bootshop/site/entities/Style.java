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
 * Style generated by hbm2java
 */
@Entity
@Table(name="style")
public class Style  implements java.io.Serializable {
	private static final long serialVersionUID = 1L;


     private int id;
     private String name;
     private Set<Product> products = new HashSet<Product>(0);

    public Style() {
    }

	
    public Style(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Style(int id, String name, Set<Product> products) {
       this.id = id;
       this.name = name;
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

    
    @Column(name="name", nullable=false)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="style")
    public Set<Product> getProducts() {
        return this.products;
    }
    
    public void setProducts(Set<Product> products) {
        this.products = products;
    }




}


