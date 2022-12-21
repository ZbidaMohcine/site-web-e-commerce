package com.springcourse.springcor.controller;

import com.springcourse.springcor.dao.ProductDao;
import com.springcourse.springcor.dao.TestDao;
import com.springcourse.springcor.entity.ProductEntity;
import com.springcourse.springcor.entity.TestEntity;
import com.springcourse.springcor.payload.ProdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/Product")

public class ProductController {
    @Autowired
    private ProductDao productDao;


    @GetMapping("/testprod")
    public String test() {
        return "test controller";
    }


    @PostMapping("/save-prod")
    public ProductEntity saveProduct(@RequestBody ProductEntity product) {
        return this.productDao.saveproduct(product);
    }

    @GetMapping(path = "/get-products")
    public Iterable<ProductEntity> getProducts() {
        return this.productDao.getProducts();
    }

    @GetMapping("/get-product/{id}")
    public Optional<ProductEntity> getProductById(@PathVariable Integer id) {
//        Optional<ProductEntity> product = productDao.getProductById(id);

        return this.productDao.getProductById(id);
    }

    @PostMapping("/test10")
    public  void EditMultiStock(@RequestBody List<ProdDto> ps){
        productDao.EditMultiStock(ps);
    }

    //count nombre of products
    @GetMapping("/getNombreOfProducts")
    public long getNombreOfProducts(){
        return this.productDao.getNombreOfProducts();
    }

    // Delete Product
     @DeleteMapping("/deleteProduct/{id}")
        public void deleteProduct(@PathVariable Integer id){
            productDao.deleteProductByid(id);
        }

}
