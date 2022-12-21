package com.springcourse.springcor.repository;

import com.springcourse.springcor.entity.CategorieEntity;
import com.springcourse.springcor.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepo extends JpaRepository<CategorieEntity, Integer > {
   CategorieEntity getCategorieEntityByCategorieNom(String name);
}
