package com.shoes.repositoty;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shoes.entity.Brand;

import java.util.List;


@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

	@Query("SELECT e FROM Brand e")
	Page<Brand> findBrand(Pageable pageable);

	Brand findByNameContaining(String username);

	@Query(value = "SELECT * FROM brand WHERE brand.name like %?1% and brand.id like %?2%",
			nativeQuery = true)
	List<Brand> search(String name, String id);
}