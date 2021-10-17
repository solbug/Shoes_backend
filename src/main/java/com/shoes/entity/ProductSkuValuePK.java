package com.shoes.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the product_sku_value database table.
 * 
 */
@Embeddable
public class ProductSkuValuePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int id_productSku;

	@Column(insertable=false, updatable=false)
	private int id_skuValue;

	public ProductSkuValuePK() {
	}
	public int getId_productSku() {
		return this.id_productSku;
	}
	public void setId_productSku(int id_productSku) {
		this.id_productSku = id_productSku;
	}
	public int getId_skuValue() {
		return this.id_skuValue;
	}
	public void setId_skuValue(int id_skuValue) {
		this.id_skuValue = id_skuValue;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProductSkuValuePK)) {
			return false;
		}
		ProductSkuValuePK castOther = (ProductSkuValuePK)other;
		return 
			(this.id_productSku == castOther.id_productSku)
			&& (this.id_skuValue == castOther.id_skuValue);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id_productSku;
		hash = hash * prime + this.id_skuValue;
		
		return hash;
	}
}