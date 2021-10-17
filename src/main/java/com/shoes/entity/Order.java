package com.shoes.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name="orders")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String address;

	@Column(name="purchase_date")
	private Timestamp purchaseDate;

	private int status;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_users")
	private User user;

	//bi-directional many-to-one association to OrdersDetail
	@OneToMany(mappedBy="order")
	private List<OrdersDetail> ordersDetails;

	//bi-directional many-to-one association to ReturnItem
	@OneToMany(mappedBy="order")
	private List<ReturnItem> returnItems;

	public Order() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getPurchaseDate() {
		return this.purchaseDate;
	}

	public void setPurchaseDate(Timestamp purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrdersDetail> getOrdersDetails() {
		return this.ordersDetails;
	}

	public void setOrdersDetails(List<OrdersDetail> ordersDetails) {
		this.ordersDetails = ordersDetails;
	}

	public OrdersDetail addOrdersDetail(OrdersDetail ordersDetail) {
		getOrdersDetails().add(ordersDetail);
		ordersDetail.setOrder(this);

		return ordersDetail;
	}

	public OrdersDetail removeOrdersDetail(OrdersDetail ordersDetail) {
		getOrdersDetails().remove(ordersDetail);
		ordersDetail.setOrder(null);

		return ordersDetail;
	}

	public List<ReturnItem> getReturnItems() {
		return this.returnItems;
	}

	public void setReturnItems(List<ReturnItem> returnItems) {
		this.returnItems = returnItems;
	}

	public ReturnItem addReturnItem(ReturnItem returnItem) {
		getReturnItems().add(returnItem);
		returnItem.setOrder(this);

		return returnItem;
	}

	public ReturnItem removeReturnItem(ReturnItem returnItem) {
		getReturnItems().remove(returnItem);
		returnItem.setOrder(null);

		return returnItem;
	}

}