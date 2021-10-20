package com.shoes.mapper.imp;

import com.shoes.config.ModelMapperConfig;
import com.shoes.entity.Brand;
import com.shoes.mapper.BrandMapper;
import com.shoes.mapper.BrandMapper;
import com.shoes.vo.BrandVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BrandMapperImp implements BrandMapper {
	ModelMapper modelMapper;
	@Autowired
	private ModelMapperConfig modelMapperConfig;

	@Override
	public Brand toEntity(BrandVO vo) {
		modelMapper = new ModelMapper();
		Brand brand = modelMapper.map(vo, Brand.class);
		return brand;
	}

	@Override
	public BrandVO toDto(Brand entity) {
		modelMapper = new ModelMapper();
		BrandVO brandsVO = modelMapper.map(entity, BrandVO.class);
		return brandsVO;
	}

	@Override
	public List<Brand> toEntity(List<BrandVO> voList) {
		List<Brand> brandList = new ArrayList<>();
		voList.forEach((vo) -> {
			brandList.add(toEntity(vo));
		});
		return brandList;
	}

	@Override
	public List<BrandVO> toDto(List<Brand> entityList) {
		List<BrandVO> brandsVOList = new ArrayList<>();
		entityList.forEach((entity) -> {
			brandsVOList.add(toDto(entity));
		});
		return brandsVOList;
	}
}
