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
@Table(name="brand_detail")
@NamedQuery(name="BrandDetail.findAll", query="SELECT b FROM BrandDetail b")
public class BrandDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BrandDetailPK id;

	//bi-directional many-to-one association to Brand
	@ManyToOne
	@JoinColumn(name="id_brand",referencedColumnName = "id", insertable = false, updatable = false)
	private Brand brand;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="id_product",referencedColumnName = "id", insertable = false, updatable = false)
	private Product product;
}