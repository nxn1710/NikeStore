package com.bootshop.site.entities;
// Generated Mar 5, 2021 10:34:32 AM by Hibernate Tools 4.3.1


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.transaction.Transactional;

/**
 * Order generated by hbm2java
 */
@Entity
@Table(name="`order`")
public class Order  implements java.io.Serializable {
	private static final long serialVersionUID = 1L;


     private int id;
     private OrderAddress orderAddress;
     private Date time;
     private boolean status;
     private Set<OrderDetails> orderDetailses = new HashSet<OrderDetails>(0);

    public Order() {
    }

	
    public Order(int id, OrderAddress orderAddress, Date time, boolean status) {
        this.id = id;
        this.orderAddress = orderAddress;
        this.time = time;
        this.status = status;
    }
    public Order(int id, OrderAddress orderAddress, Date time, boolean status, Set<OrderDetails> orderDetailses) {
       this.id = id;
       this.orderAddress = orderAddress;
       this.time = time;
       this.status = status;
       this.orderDetailses = orderDetailses;
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

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="order_address_id", nullable=false)
    public OrderAddress getOrderAddress() {
        return this.orderAddress;
    }
    
    public void setOrderAddress(OrderAddress orderAddress) {
        this.orderAddress = orderAddress;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="time", nullable=false, length=23)
    public Date getTime() {
        return this.time;
    }
    
    public void setTime(Date time) {
        this.time = time;
    }

    
    @Column(name="status", nullable=false)
    public boolean isStatus() {
        return this.status;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="order")
    public Set<OrderDetails> getOrderDetailses() {
        return this.orderDetailses;
    }
    
    public void setOrderDetailses(Set<OrderDetails> orderDetailses) {
        this.orderDetailses = orderDetailses;
    }

    @Transient
    public String getFormatTime() {
    	SimpleDateFormat  simpleDateFormat = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
    	return simpleDateFormat.format(time);
    }


}


