package com.shoes.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the product_sku_value database table.
 * 
 */
@Entity
@Table(name="product_sku_value")
@NamedQuery(name="ProductSkuValue.findAll", query="SELECT p FROM ProductSkuValue p")
public class ProductSkuValue implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductSkuValuePK id;

	//bi-directional many-to-one association to SkuValue
	@ManyToOne
	@JoinColumn(name="id_skuValue")
	private SkuValue skuValue;

	//bi-directional many-to-one association to ProductSku
	@ManyToOne
	@JoinColumn(name="id_productSku")
	private ProductSku productSku;

	public ProductSkuValue() {
	}

	public ProductSkuValuePK getId() {
		return this.id;
	}

	public void setId(ProductSkuValuePK id) {
		this.id = id;
	}

	public SkuValue getSkuValue() {
		return this.skuValue;
	}

	public void setSkuValue(SkuValue skuValue) {
		this.skuValue = skuValue;
	}

	public ProductSku getProductSku() {
		return this.productSku;
	}

	public void setProductSku(ProductSku productSku) {
		this.productSku = productSku;
	}

}