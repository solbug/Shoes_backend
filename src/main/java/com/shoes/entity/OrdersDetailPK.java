package com.shoes.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the orders_detail database table.
 * 
 */
@Embeddable
public class OrdersDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_order", insertable=false, updatable=false)
	private int idOrder;

	@Column(insertable=false, updatable=false)
	private int id_productSku;

	public OrdersDetailPK() {
	}
	public int getIdOrder() {
		return this.idOrder;
	}
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
	public int getId_productSku() {
		return this.id_productSku;
	}
	public void setId_productSku(int id_productSku) {
		this.id_productSku = id_productSku;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OrdersDetailPK)) {
			return false;
		}
		OrdersDetailPK castOther = (OrdersDetailPK)other;
		return 
			(this.idOrder == castOther.idOrder)
			&& (this.id_productSku == castOther.id_productSku);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idOrder;
		hash = hash * prime + this.id_productSku;
		
		return hash;
	}
}