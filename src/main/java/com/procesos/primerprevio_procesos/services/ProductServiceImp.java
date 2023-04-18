package com.procesos.primerprevio_procesos.services;

import com.procesos.primerprevio_procesos.models.Product;
import com.procesos.primerprevio_procesos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRespository;

    public Product getProduct(Long id){
        return productRespository.findById(id).get();
    }

    @Override
    public Boolean createProduct(Product product){
        try{
            productRespository.save(product);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public List<Product> allProducts(){
        return productRespository.findAll();
    }

    @Override
    public Boolean updateProduct(Long id, Product product){
        try{
            Product productBD = productRespository.findById(id).get();

            productBD.setName(product.getName());
            productBD.setPrice(product.getPrice());
            productRespository.save(productBD);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}

