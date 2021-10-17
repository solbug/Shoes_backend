package com.shoes.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the brand database table.
 * 
 */
@Entity
@NamedQuery(name="Brand.findAll", query="SELECT b FROM Brand b")
public class Brand implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to BrandDetail
	@OneToMany(mappedBy="brand")
	private List<BrandDetail> brandDetails;

	public Brand() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BrandDetail> getBrandDetails() {
		return this.brandDetails;
	}

	public void setBrandDetails(List<BrandDetail> brandDetails) {
		this.brandDetails = brandDetails;
	}

	public BrandDetail addBrandDetail(BrandDetail brandDetail) {
		getBrandDetails().add(brandDetail);
		brandDetail.setBrand(this);

		return brandDetail;
	}

	public BrandDetail removeBrandDetail(BrandDetail brandDetail) {
		getBrandDetails().remove(brandDetail);
		brandDetail.setBrand(null);

		return brandDetail;
	}

}