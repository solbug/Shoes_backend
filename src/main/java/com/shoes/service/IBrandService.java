package com.shoes.service;


import java.util.List;
import java.util.Optional;

import com.shoes.entity.Brand;
import com.shoes.vo.BrandVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBrandService {
    Brand findByName(String name);

    BrandVO save(BrandVO brandVO);

    List<BrandVO> findAll(Pageable pageable);

    BrandVO findOneById(Integer id);

    Optional<Brand> findById(Integer id);

    void deleteBrandById(Integer id);

    List<BrandVO> search(String name, String id);

}
