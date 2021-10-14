package com.shoes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the brand database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NamedQuery(name="Brand.findAll", query="SELECT b FROM Brand b")
public class Brand implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int name;

	//bi-directional many-to-many association to Product
	@ManyToMany
	@JoinTable(
		name="branddetail"
		, joinColumns={
			@JoinColumn(name="id_brand")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_product")
			}
		)
	private List<Product> products;

}