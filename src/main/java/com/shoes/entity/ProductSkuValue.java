package com.shoes.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product_sku_value")
@NamedQuery(name="ProductSkuValue.findAll", query="SELECT p FROM ProductSkuValue p")
public class ProductSkuValue implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductSkuValuePK id;

	//bi-directional many-to-one association to SkuValue
	@ManyToOne
	@JoinColumn(name="id_skuValue",referencedColumnName = "id", insertable = false, updatable = false)
	private SkuValue skuValue;

	//bi-directional many-to-one association to ProductSku
	@ManyToOne
	@JoinColumn(name="id_productSku",referencedColumnName = "id", insertable = false, updatable = false)
	private ProductSku productSku;

	
}