package com.shoes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the productsku database table.
 * 
 */
@Data
@AllArgsConstructor
@Entity
@NamedQuery(name="Productsku.findAll", query="SELECT p FROM Productsku p")
public class Productsku implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private double gia;

	private String hinh;

	private String sku;

	//bi-directional many-to-one association to Orderdetail
	@OneToMany(mappedBy="productsku")
	private List<Orderdetail> orderdetails;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="id_sanpham")
	private Product product;

	//bi-directional many-to-one association to Returnitem
	@OneToMany(mappedBy="productsku")
	private List<Returnitem> returnitems;


}