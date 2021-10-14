package com.shoes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@Table(name="orders")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String addres;

	@Column(name="create_date")
	private String createDate;

	private int status;

	//bi-directional many-to-one association to Orderdetail
	@OneToMany(mappedBy="order")
	private List<Orderdetail> orderdetails;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	//bi-directional many-to-one association to Returnitem
	@OneToMany(mappedBy="order")
	private List<Returnitem> returnitems;

}