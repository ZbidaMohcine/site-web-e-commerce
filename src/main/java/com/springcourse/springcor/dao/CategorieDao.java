package com.springcourse.springcor.dao;


import com.springcourse.springcor.entity.CategorieEntity;
import com.springcourse.springcor.repository.CategorieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieDao {


    @Autowired
    private CategorieRepo categorieRepo;




    public List<CategorieEntity> getcategories() {
        return this.categorieRepo.findAll();

    }

    public CategorieEntity getcategory(String name) {

        return this.categorieRepo.getCategorieEntityByCategorieNom(name);
    }
    public CategorieEntity saveCategorie(CategorieEntity categorie) {

        return this.categorieRepo.save(categorie);
    }
}
