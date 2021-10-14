package com.shoes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the returnitem database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NamedQuery(name="Returnitem.findAll", query="SELECT r FROM Returnitem r")
public class Returnitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String bank_Transfer;

	private String description;

	private int status;

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

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;


}