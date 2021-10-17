package com.shoes.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product_sku database table.
 * 
 */
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

	public ProductSku() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSku() {
		return this.sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public List<OrdersDetail> getOrdersDetails() {
		return this.ordersDetails;
	}

	public void setOrdersDetails(List<OrdersDetail> ordersDetails) {
		this.ordersDetails = ordersDetails;
	}

	public OrdersDetail addOrdersDetail(OrdersDetail ordersDetail) {
		getOrdersDetails().add(ordersDetail);
		ordersDetail.setProductSku(this);

		return ordersDetail;
	}

	public OrdersDetail removeOrdersDetail(OrdersDetail ordersDetail) {
		getOrdersDetails().remove(ordersDetail);
		ordersDetail.setProductSku(null);

		return ordersDetail;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<ReturnItem> getReturnItems() {
		return this.returnItems;
	}

	public void setReturnItems(List<ReturnItem> returnItems) {
		this.returnItems = returnItems;
	}

	public ReturnItem addReturnItem(ReturnItem returnItem) {
		getReturnItems().add(returnItem);
		returnItem.setProductSku(this);

		return returnItem;
	}

	public ReturnItem removeReturnItem(ReturnItem returnItem) {
		getReturnItems().remove(returnItem);
		returnItem.setProductSku(null);

		return returnItem;
	}

	public List<ProductSkuValue> getProductSkuValues() {
		return this.productSkuValues;
	}

	public void setProductSkuValues(List<ProductSkuValue> productSkuValues) {
		this.productSkuValues = productSkuValues;
	}

	public ProductSkuValue addProductSkuValue(ProductSkuValue productSkuValue) {
		getProductSkuValues().add(productSkuValue);
		productSkuValue.setProductSku(this);

		return productSkuValue;
	}

	public ProductSkuValue removeProductSkuValue(ProductSkuValue productSkuValue) {
		getProductSkuValues().remove(productSkuValue);
		productSkuValue.setProductSku(null);

		return productSkuValue;
	}

}