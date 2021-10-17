package com.shoes.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
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

}