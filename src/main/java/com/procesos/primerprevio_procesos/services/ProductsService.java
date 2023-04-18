package com.procesos.primerprevio_procesos.services;

import com.procesos.primerprevio_procesos.models.Products;

import java.util.List;

public interface ProductsService {
    Products getProducts(Long id);
    Boolean saveProducts(Products products);
    List<Products> allProducts();
    Boolean updateProduct(Long id, Products products);

}
