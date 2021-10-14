package com.shoes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the skuvalue database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NamedQuery(name="Skuvalue.findAll", query="SELECT s FROM Skuvalue s")
public class Skuvalue implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SkuvaluePK id;

	//bi-directional many-to-one association to Option
	@ManyToOne
	@JoinColumn(name="id_option")
	private Option option;

	//bi-directional many-to-one association to Optionvalue
	@ManyToOne
	@JoinColumn(name="id_option_value")
	private Optionvalue optionvalue;


}