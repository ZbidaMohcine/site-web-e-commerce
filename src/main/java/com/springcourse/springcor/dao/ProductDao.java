package com.springcourse.springcor.dao;


import com.springcourse.springcor.entity.ProductEntity;
import com.springcourse.springcor.payload.ProdDto;
import com.springcourse.springcor.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDao {


    @Autowired
    private ProductRepo productRepo;



    public ProductEntity saveproduct(ProductEntity product) {

        return this.productRepo.save(product);
    }


    public List<ProductEntity> getProducts()
    {
        return this.productRepo.findAll();
    }

    public Optional<ProductEntity> getProductById(Integer id) {
        return this.productRepo.findById(id);
    }

    public String EditStock(ProdDto p) {
        Optional<ProductEntity> prod = productRepo.findById(p.getId());
        Long Stock = prod.get().getStock();
        if (p.getStock() < Stock) {
            Long newStock = Stock - p.getStock();
            prod.get().setStock(newStock);
            productRepo.save(prod.get());
            return "succes !";
        }
        else
            return "not ok";

    }


    public  void EditMultiStock(List<ProdDto> ps){

        for (ProdDto p1:ps){
            EditStock(p1);
        }

    }

    public long getNombreOfProducts(){
        return this.productRepo.count();
    }

    public void deleteProductByid(Integer id){
         productRepo.deleteById(id);
    }
}
