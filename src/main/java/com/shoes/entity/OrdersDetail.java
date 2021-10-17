package com.shoes.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the orders_detail database table.
 * 
 */
@Entity
@Table(name="orders_detail")
@NamedQuery(name="OrdersDetail.findAll", query="SELECT o FROM OrdersDetail o")
public class OrdersDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrdersDetailPK id;

	private int quantity;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="id_order")
	private Order order;

	//bi-directional many-to-one association to ProductSku
	@ManyToOne
	@JoinColumn(name="id_productSku")
	private ProductSku productSku;

	public OrdersDetail() {
	}

	public OrdersDetailPK getId() {
		return this.id;
	}

	public void setId(OrdersDetailPK id) {
		this.id = id;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

}