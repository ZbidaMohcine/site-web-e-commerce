package com.springcourse.springcor.repository;

import com.springcourse.springcor.entity.ProductEntity;
import com.springcourse.springcor.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<ProductEntity, Integer > {
}
