package com.shoes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the skuvalue database table.
 * 
 */
@Data
@AllArgsConstructor
@Embeddable
public class SkuvaluePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(name="id_option", insertable=false, updatable=false)
	private int idOption;

	@Column(name="id_option_value", insertable=false, updatable=false)
	private int idOptionValue;

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SkuvaluePK)) {
			return false;
		}
		SkuvaluePK castOther = (SkuvaluePK)other;
		return 
			(this.id == castOther.id)
			&& (this.idOption == castOther.idOption)
			&& (this.idOptionValue == castOther.idOptionValue);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.idOption;
		hash = hash * prime + this.idOptionValue;
		
		return hash;
	}
}