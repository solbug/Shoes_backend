package com.shoes.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the option_value database table.
 * 
 */
@Entity
@Table(name="option_value")
@NamedQuery(name="OptionValue.findAll", query="SELECT o FROM OptionValue o")
public class OptionValue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="value_name")
	private String valueName;

	//bi-directional many-to-one association to Option
	@ManyToOne
	@JoinColumn(name="id_options")
	private Option option;

	//bi-directional many-to-one association to SkuValue
	@OneToMany(mappedBy="optionValue")
	private List<SkuValue> skuValues;

	public OptionValue() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValueName() {
		return this.valueName;
	}

	public void setValueName(String valueName) {
		this.valueName = valueName;
	}

	public Option getOption() {
		return this.option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

	public List<SkuValue> getSkuValues() {
		return this.skuValues;
	}

	public void setSkuValues(List<SkuValue> skuValues) {
		this.skuValues = skuValues;
	}

	public SkuValue addSkuValue(SkuValue skuValue) {
		getSkuValues().add(skuValue);
		skuValue.setOptionValue(this);

		return skuValue;
	}

	public SkuValue removeSkuValue(SkuValue skuValue) {
		getSkuValues().remove(skuValue);
		skuValue.setOptionValue(null);

		return skuValue;
	}

}