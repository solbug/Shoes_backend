package com.shoes.vo;

import com.shoes.entity.BrandDetail;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BrandVO implements Serializable {
	private static final long serialVersionUID = 1L;


	private Integer id;

	private String name;

}