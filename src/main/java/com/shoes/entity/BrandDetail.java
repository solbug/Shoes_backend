package com.shoes.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the brand_detail database table.
 * 
 */
@Entity
@Table(name="brand_detail")
@NamedQuery(name="BrandDetail.findAll", query="SELECT b FROM BrandDetail b")
public class BrandDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BrandDetailPK id;

	//bi-directional many-to-one association to Brand
	@ManyToOne
	@JoinColumn(name="id_brand")
	private Brand brand;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="id_product")
	private Product product;

	public BrandDetail() {
	}

	public BrandDetailPK getId() {
		return this.id;
	}

	public void setId(BrandDetailPK id) {
		this.id = id;
	}

	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}