package com.shoes.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
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
}