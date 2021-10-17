package com.shoes.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	private String name;

	//bi-directional many-to-one association to Option
	@OneToMany(mappedBy="product")
	private List<Option> options;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="id_category")
	private Category category;

	//bi-directional many-to-one association to ProductSku
	@OneToMany(mappedBy="product")
	private List<ProductSku> productSkus;

	//bi-directional many-to-one association to Rate
	@OneToMany(mappedBy="product")
	private List<Rate> rates;

	//bi-directional many-to-one association to BrandDetail
	@OneToMany(mappedBy="product")
	private List<BrandDetail> brandDetails;

	public Product() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Option> getOptions() {
		return this.options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public Option addOption(Option option) {
		getOptions().add(option);
		option.setProduct(this);

		return option;
	}

	public Option removeOption(Option option) {
		getOptions().remove(option);
		option.setProduct(null);

		return option;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<ProductSku> getProductSkus() {
		return this.productSkus;
	}

	public void setProductSkus(List<ProductSku> productSkus) {
		this.productSkus = productSkus;
	}

	public ProductSku addProductSkus(ProductSku productSkus) {
		getProductSkus().add(productSkus);
		productSkus.setProduct(this);

		return productSkus;
	}

	public ProductSku removeProductSkus(ProductSku productSkus) {
		getProductSkus().remove(productSkus);
		productSkus.setProduct(null);

		return productSkus;
	}

	public List<Rate> getRates() {
		return this.rates;
	}

	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}

	public Rate addRate(Rate rate) {
		getRates().add(rate);
		rate.setProduct(this);

		return rate;
	}

	public Rate removeRate(Rate rate) {
		getRates().remove(rate);
		rate.setProduct(null);

		return rate;
	}

	public List<BrandDetail> getBrandDetails() {
		return this.brandDetails;
	}

	public void setBrandDetails(List<BrandDetail> brandDetails) {
		this.brandDetails = brandDetails;
	}

	public BrandDetail addBrandDetail(BrandDetail brandDetail) {
		getBrandDetails().add(brandDetail);
		brandDetail.setProduct(this);

		return brandDetail;
	}

	public BrandDetail removeBrandDetail(BrandDetail brandDetail) {
		getBrandDetails().remove(brandDetail);
		brandDetail.setProduct(null);

		return brandDetail;
	}

}