package com.shoes.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
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

}