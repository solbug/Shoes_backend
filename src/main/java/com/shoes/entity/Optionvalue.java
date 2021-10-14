package com.shoes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the optionvalue database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NamedQuery(name="Optionvalue.findAll", query="SELECT o FROM Optionvalue o")
public class Optionvalue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String value;

	//bi-directional many-to-one association to Option
	@ManyToOne
	@JoinColumn(name="id_option")
	private Option option;

	//bi-directional many-to-one association to Skuvalue
	@OneToMany(mappedBy="optionvalue")
	private List<Skuvalue> skuvalues;

}