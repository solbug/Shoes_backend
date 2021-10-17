package com.shoes.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
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
}