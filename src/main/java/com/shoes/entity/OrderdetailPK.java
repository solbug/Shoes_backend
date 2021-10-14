package com.shoes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the orderdetail database table.
 * 
 */
@Data
@AllArgsConstructor
@Embeddable
public class OrderdetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_order", insertable=false, updatable=false)
	private int idOrder;

	@Column(name="id_product", insertable=false, updatable=false)
	private int idProduct;

	@Column(name="id_sku", insertable=false, updatable=false)
	private int idSku;

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OrderdetailPK)) {
			return false;
		}
		OrderdetailPK castOther = (OrderdetailPK)other;
		return 
			(this.idOrder == castOther.idOrder)
			&& (this.idProduct == castOther.idProduct)
			&& (this.idSku == castOther.idSku);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idOrder;
		hash = hash * prime + this.idProduct;
		hash = hash * prime + this.idSku;
		
		return hash;
	}
}