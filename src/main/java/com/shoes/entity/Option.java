package com.shoes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the option database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NamedQuery(name="Option.findAll", query="SELECT o FROM Option o")
public class Option implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="id_product")
	private Product product;

	//bi-directional many-to-one association to Optionvalue
	@OneToMany(mappedBy="option")
	private List<Optionvalue> optionvalues;

	//bi-directional many-to-one association to Skuvalue
	@OneToMany(mappedBy="option")
	private List<Skuvalue> skuvalues;

}