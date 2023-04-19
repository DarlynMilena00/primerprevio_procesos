package com.procesos.primerprevio_procesos.services;

import com.procesos.primerprevio_procesos.models.Products;
import com.procesos.primerprevio_procesos.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImp implements ProductsService {
    @Autowired
    private ProductsRepository productsRepository;
    @Override
    public Boolean saveProducts(Products products) {
        try{
            productsRepository.save(products);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public Products getProducts(Long id){
        return productsRepository.findById(id).get();
    }

    @Override
    public List<Products> allProducts() {
        return productsRepository.findAll();
    }

    @Override
    public Boolean updateProducts(Long id, Products products) {
        try{
            productsRepository.save(products);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}

