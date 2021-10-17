package com.shoes.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sku_value database table.
 * 
 */
@Entity
@Table(name="sku_value")
@NamedQuery(name="SkuValue.findAll", query="SELECT s FROM SkuValue s")
public class SkuValue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to OptionValue
	@ManyToOne
	@JoinColumn(name="id_optionValue")
	private OptionValue optionValue;

	//bi-directional many-to-one association to Option
	@ManyToOne
	@JoinColumn(name="id_options")
	private Option option;

	//bi-directional many-to-one association to ProductSkuValue
	@OneToMany(mappedBy="skuValue")
	private List<ProductSkuValue> productSkuValues;

	public SkuValue() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OptionValue getOptionValue() {
		return this.optionValue;
	}

	public void setOptionValue(OptionValue optionValue) {
		this.optionValue = optionValue;
	}

	public Option getOption() {
		return this.option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

	public List<ProductSkuValue> getProductSkuValues() {
		return this.productSkuValues;
	}

	public void setProductSkuValues(List<ProductSkuValue> productSkuValues) {
		this.productSkuValues = productSkuValues;
	}

	public ProductSkuValue addProductSkuValue(ProductSkuValue productSkuValue) {
		getProductSkuValues().add(productSkuValue);
		productSkuValue.setSkuValue(this);

		return productSkuValue;
	}

	public ProductSkuValue removeProductSkuValue(ProductSkuValue productSkuValue) {
		getProductSkuValues().remove(productSkuValue);
		productSkuValue.setSkuValue(null);

		return productSkuValue;
	}

}