package com.shoes.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product_sku")
@NamedQuery(name="ProductSku.findAll", query="SELECT p FROM ProductSku p")
public class ProductSku implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String image;

	private double price;

	private String sku;

	//bi-directional many-to-one association to OrdersDetail
	@OneToMany(mappedBy="productSku")
	private List<OrdersDetail> ordersDetails;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="id_product")
	private Product product;

	//bi-directional many-to-one association to ReturnItem
	@OneToMany(mappedBy="productSku")
	private List<ReturnItem> returnItems;

	//bi-directional many-to-one association to ProductSkuValue
	@OneToMany(mappedBy="productSku")
	private List<ProductSkuValue> productSkuValues;
}