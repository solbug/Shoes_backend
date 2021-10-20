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
@Table(name="sku_value")
@NamedQuery(name="SkuValue.findAll", query="SELECT s FROM SkuValue s")
public class SkuValue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

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
}