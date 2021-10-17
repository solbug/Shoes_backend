package com.shoes.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the brand_detail database table.
 * 
 */
@Embeddable
public class BrandDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_product", insertable=false, updatable=false)
	private int idProduct;

	@Column(name="id_brand", insertable=false, updatable=false)
	private int idBrand;

	public BrandDetailPK() {
	}
	public int getIdProduct() {
		return this.idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public int getIdBrand() {
		return this.idBrand;
	}
	public void setIdBrand(int idBrand) {
		this.idBrand = idBrand;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BrandDetailPK)) {
			return false;
		}
		BrandDetailPK castOther = (BrandDetailPK)other;
		return 
			(this.idProduct == castOther.idProduct)
			&& (this.idBrand == castOther.idBrand);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idProduct;
		hash = hash * prime + this.idBrand;
		
		return hash;
	}
}