package com.shoes.controller;

import com.shoes.service.ICategoryService;
import com.shoes.vo.CategoryVO;
import com.shoes.vo.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @GetMapping("/add")
    public ResponseEntity<?> addCategory(@RequestBody CategoryVO categoryVO){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(categoryVO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryVO> finOneById(@PathVariable("id") Integer id){
        CategoryVO categoryVO = categoryService.findOneById((id));
        return ResponseEntity.status(HttpStatus.OK).body(categoryVO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Integer id){
        categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageVO("Xóa thành công"));
    }
}
