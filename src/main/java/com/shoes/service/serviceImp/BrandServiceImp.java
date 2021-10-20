package com.shoes.service.serviceImp;
import com.shoes.mapper.BrandMapper;
import com.shoes.service.IBrandService;
import com.shoes.vo.BrandVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shoes.entity.Brand;
import com.shoes.repositoty.BrandRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImp implements IBrandService {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private BrandRepository brandRepository;

	@Autowired
	private BrandMapper brandMapper;

	@Override
	public Brand findByName(String name) {
		return brandRepository.findByNameContaining(name);
	}

	@Override
	public BrandVO save(BrandVO brandVO) {
		Brand brand = brandMapper.toEntity(brandVO);
		Brand brandNew = brandRepository.save(brand);
		return brandMapper.toDto(brandNew);
	}

	@Override
	public List<BrandVO> findAll(Pageable pageable) {
		Page<Brand> brands =brandRepository.findBrand(pageable);
		List<Brand> brandList = brands.getContent();
		return brandMapper.toDto(brandList);
	}

	@Override
	public BrandVO findOneById(Integer id) {
		Optional<Brand> brandOptional = brandRepository.findById(id);
		if (brandOptional.isPresent()) {
			return brandMapper.toDto(brandOptional.get());
		} else {
			return null;
		}
	}

	@Override
	public Optional<Brand> findById(Integer id) {
		return brandRepository.findById(id);
	}

	@Override
	public void deleteBrandById(Integer id) {
		brandRepository.deleteById(id);
	}
	@Override
	public  List<BrandVO> search(String name, String id) {
		List<Brand> brandList = brandRepository.search(name, id);
		return brandMapper.toDto(brandList);
	}
		
}
