package com.shoes.service;

import com.shoes.entity.Category;
import com.shoes.vo.CategoryVO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    Category findByName(String name);
    CategoryVO save(CategoryVO categoryVO);
    CategoryVO update(CategoryVO categoryVO);
    List<Category> findAll(Pageable pageable);
    CategoryVO findOneById(Integer id);
    Optional<Category> findById(Integer id);
    void deleteCategory(Integer id);
}
