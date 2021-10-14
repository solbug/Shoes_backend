package com.shoes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the orderdetail database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NamedQuery(name="Orderdetail.findAll", query="SELECT o FROM Orderdetail o")
public class Orderdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderdetailPK id;

	private int quantity;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="id_order")
	private Order order;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="id_product")
	private Product product;

	//bi-directional many-to-one association to Productsku
	@ManyToOne
	@JoinColumn(name="id_sku")
	private Productsku productsku;

}