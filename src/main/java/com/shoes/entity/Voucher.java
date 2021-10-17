package com.shoes.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the voucher database table.
 * 
 */
@Entity
@NamedQuery(name="Voucher.findAll", query="SELECT v FROM Voucher v")
public class Voucher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	@Column(name="end_date")
	private Timestamp endDate;

	@Column(name="max_value")
	private double maxValue;

	@Column(name="min_value")
	private double minValue;

	private String name;

	@Column(name="percent_discount")
	private int percentDiscount;

	@Column(name="start_date")
	private Timestamp startDate;

	private int status;

	public Voucher() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public double getMaxValue() {
		return this.maxValue;
	}

	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}

	public double getMinValue() {
		return this.minValue;
	}

	public void setMinValue(double minValue) {
		this.minValue = minValue;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPercentDiscount() {
		return this.percentDiscount;
	}

	public void setPercentDiscount(int percentDiscount) {
		this.percentDiscount = percentDiscount;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}