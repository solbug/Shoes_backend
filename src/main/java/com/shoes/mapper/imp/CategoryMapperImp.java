package com.shoes.mapper.imp;

import com.shoes.config.ModelMapperConfig;
import com.shoes.entity.Category;
import com.shoes.mapper.CategoryMapper;
import com.shoes.vo.CategoryVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryMapperImp implements CategoryMapper {
    ModelMapper modelMapper;
    @Autowired
    private ModelMapperConfig modelMapperConfig;

    @Override
    public Category toEntity(CategoryVO vo) {
        modelMapper = new ModelMapper();
        Category category = modelMapper.map(vo, Category.class);
        return category;
    }

    @Override
    public CategoryVO toDto(Category entity) {
        modelMapper = new ModelMapper();
        CategoryVO categoryVO = modelMapper.map(entity, CategoryVO.class);
        return categoryVO;
    }

    @Override
    public List<Category> toEntity(List<CategoryVO> voList) {
        List<Category> categoryList = new ArrayList<>();
        voList.forEach((vo) ->{
            categoryList.add(toEntity(vo));
        });
        return categoryList;
    }

    @Override
    public List<CategoryVO> toDto(List<Category> entityList) {
        List<CategoryVO> categoryVOList = new ArrayList<>();
        entityList.forEach((entity) ->{
            categoryVOList.add(toDto(entity));
        });
        return categoryVOList;
    }
}
