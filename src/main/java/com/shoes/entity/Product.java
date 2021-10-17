package com.shoes.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String description;

	private String name;

	// bi-directional many-to-one association to Option
	@OneToMany(mappedBy = "product")
	private List<Option> options;

	// bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name = "id_category")
	private Category category;

	// bi-directional many-to-one association to ProductSku
	@OneToMany(mappedBy = "product")
	private List<ProductSku> productSkus;

	// bi-directional many-to-one association to Rate
	@OneToMany(mappedBy = "product")
	private List<Rate> rates;

	// bi-directional many-to-one association to BrandDetail
	@OneToMany(mappedBy = "product")
	private List<BrandDetail> brandDetails;
}