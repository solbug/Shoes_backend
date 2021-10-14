package com.shoes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the voucher database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NamedQuery(name="Voucher.findAll", query="SELECT v FROM Voucher v")
public class Voucher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	private int discount;

	private String endDay;

	private int max;

	private int min;

	private String name;

	private String startDay;

	private int status;

}