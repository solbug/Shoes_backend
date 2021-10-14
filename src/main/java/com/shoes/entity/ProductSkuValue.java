package com.shoes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the product_sku_value database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@Table(name="product_sku_value")
@NamedQuery(name="ProductSkuValue.findAll", query="SELECT p FROM ProductSkuValue p")
public class ProductSkuValue implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductSkuValuePK id;


}