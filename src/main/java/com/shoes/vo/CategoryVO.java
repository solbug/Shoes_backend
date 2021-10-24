package com.shoes.vo;

import com.shoes.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryVO {
    private Integer id;
    private String name;
    private Integer parent_id;
    private Integer level;
}
