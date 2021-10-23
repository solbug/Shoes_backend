package com.shoes.service.serviceImp;

import com.shoes.entity.Category;
import com.shoes.mapper.CategoryMapper;
import com.shoes.repositoty.CategoryRepository;
import com.shoes.service.ICategoryService;
import com.shoes.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImp implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Category findByName(String name) {
        return null;
    }

    @Override
    public CategoryVO save(CategoryVO categoryVO) {
        Category category = categoryMapper.toEntity(categoryVO);
        Category categoryNew = categoryRepository.save(category);
        return categoryMapper.toDto(categoryNew);
    }

    @Override
    public List<Category> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public CategoryVO findOneById(Integer id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isPresent()){
            return categoryMapper.toDto(categoryOptional.get());
        }
        return null;
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
}
