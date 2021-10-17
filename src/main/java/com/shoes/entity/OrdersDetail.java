package com.shoes.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
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
	@JoinColumn(name="id_order",referencedColumnName = "id", insertable = false, updatable = false)
	private Order order;

	//bi-directional many-to-one association to ProductSku
	@ManyToOne
	@JoinColumn(name="id_productSku",referencedColumnName = "id", insertable = false, updatable = false)
	private ProductSku productSku;
}