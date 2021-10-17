package com.shoes.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the options database table.
 * 
 */
@Entity
@Table(name="options")
@NamedQuery(name="Option.findAll", query="SELECT o FROM Option o")
public class Option implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="options_name")
	private String optionsName;

	//bi-directional many-to-one association to OptionValue
	@OneToMany(mappedBy="option")
	private List<OptionValue> optionValues;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="id_product")
	private Product product;

	//bi-directional many-to-one association to SkuValue
	@OneToMany(mappedBy="option")
	private List<SkuValue> skuValues;

	public Option() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOptionsName() {
		return this.optionsName;
	}

	public void setOptionsName(String optionsName) {
		this.optionsName = optionsName;
	}

	public List<OptionValue> getOptionValues() {
		return this.optionValues;
	}

	public void setOptionValues(List<OptionValue> optionValues) {
		this.optionValues = optionValues;
	}

	public OptionValue addOptionValue(OptionValue optionValue) {
		getOptionValues().add(optionValue);
		optionValue.setOption(this);

		return optionValue;
	}

	public OptionValue removeOptionValue(OptionValue optionValue) {
		getOptionValues().remove(optionValue);
		optionValue.setOption(null);

		return optionValue;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<SkuValue> getSkuValues() {
		return this.skuValues;
	}

	public void setSkuValues(List<SkuValue> skuValues) {
		this.skuValues = skuValues;
	}

	public SkuValue addSkuValue(SkuValue skuValue) {
		getSkuValues().add(skuValue);
		skuValue.setOption(this);

		return skuValue;
	}

	public SkuValue removeSkuValue(SkuValue skuValue) {
		getSkuValues().remove(skuValue);
		skuValue.setOption(null);

		return skuValue;
	}

}