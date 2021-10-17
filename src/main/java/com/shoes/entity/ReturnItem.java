package com.shoes.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the return_item database table.
 * 
 */
@Entity
@Table(name="return_item")
@NamedQuery(name="ReturnItem.findAll", query="SELECT r FROM ReturnItem r")
public class ReturnItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	private String payments;

	private int status;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="id_order")
	private Order order;

	//bi-directional many-to-one association to ProductSku
	@ManyToOne
	@JoinColumn(name="id_productSku")
	private ProductSku productSku;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	public ReturnItem() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPayments() {
		return this.payments;
	}

	public void setPayments(String payments) {
		this.payments = payments;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public ProductSku getProductSku() {
		return this.productSku;
	}

	public void setProductSku(ProductSku productSku) {
		this.productSku = productSku;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}