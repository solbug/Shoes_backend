package com.shoes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rate database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NamedQuery(name="Rate.findAll", query="SELECT r FROM Rate r")
public class Rate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="create_date")
	private String createDate;

	private String description;

	@Column(name="id_product")
	private int idProduct;

	private int rate;

	//bi-directional one-to-one association to Product
	@OneToOne
	@JoinColumn(name="id")
	private Product product;


}