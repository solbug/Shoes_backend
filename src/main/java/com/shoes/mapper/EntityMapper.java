package com.shoes.mapper;

import java.util.List;

public interface EntityMapper <E, D>{
    E toEntity(D vo);

    D toDto(E entity);

    List<E> toEntity(List<D> voList);

    List<D> toDto(List<E> entityList);
}
