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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * OrderAddress generated by hbm2java
 */
@Entity
@Table(name = "order_address")
public class OrderAddress implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private User user;
	private String phoneNumber;
	private String city;
	private String address;
	private Set<Order> orders = new HashSet<Order>(0);
	public OrderAddress() {
	}

	public OrderAddress(int id, User user, String phoneNumber, String city, String address) {
		this.id = id;
		this.user = user;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.address = address;
	}

	public OrderAddress(int id, User user, String phoneNumber, String city, String address, Set<Order> orders) {
		this.id = id;
		this.user = user;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.address = address;
		this.orders = orders;
	}

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "phone_number", nullable = false)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "city", nullable = false)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "address", nullable = false)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orderAddress")
	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	@Transient
	public String getAddressString() {
		return user.getFirstName() + " " + user.getLastName() + ", " + phoneNumber + ", " + address + ", " + city;
	}

}
