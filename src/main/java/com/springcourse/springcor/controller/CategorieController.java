package com.springcourse.springcor.controller;

import com.springcourse.springcor.dao.CategorieDao;
import com.springcourse.springcor.entity.CategorieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/category")

public class CategorieController {

    @Autowired
    private CategorieDao categorieDao;


    @GetMapping(path = "/get-categories")
    public List<CategorieEntity> getcategories() {
        return this.categorieDao.getcategories();
    }

    @GetMapping("/get-category/{name}")
    public CategorieEntity getcategory(@PathVariable("name") String name){
        return categorieDao.getcategory(name);
    }

    @PostMapping("/save-cat")
    public CategorieEntity saveProduct(@RequestBody CategorieEntity categorie) {
        return this.categorieDao.saveCategorie(categorie);
    }


}
