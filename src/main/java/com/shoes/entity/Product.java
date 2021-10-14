package com.shoes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	private String name;

	//bi-directional many-to-many association to Brand
	@ManyToMany(mappedBy="products")
	private List<Brand> brands;

	//bi-directional many-to-one association to Option
	@OneToMany(mappedBy="product")
	private List<Option> options;

	//bi-directional many-to-one association to Orderdetail
	@OneToMany(mappedBy="product")
	private List<Orderdetail> orderdetails;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="id_category")
	private Category category;

	//bi-directional many-to-one association to Productsku
	@OneToMany(mappedBy="product")
	private List<Productsku> productskus;

	//bi-directional one-to-one association to Rate
	@OneToOne(mappedBy="product")
	private Rate rate;

	//bi-directional many-to-one association to Returnitem
	@OneToMany(mappedBy="product")
	private List<Returnitem> returnitems;


}