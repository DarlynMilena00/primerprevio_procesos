package com.procesos.primerprevio_procesos.services;

import com.procesos.primerprevio_procesos.models.Product;

import java.util.List;

public interface ProductService {
    Product getProduct(Long id);
    Boolean createProduct(Product product);
    List<Product> allProducts();
    Boolean updateProduct(Long id, Product product);

}
