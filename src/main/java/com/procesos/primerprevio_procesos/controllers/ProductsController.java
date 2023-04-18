package com.procesos.primerprevio_procesos.controllers;

import com.procesos.primerprevio_procesos.models.Products;
import com.procesos.primerprevio_procesos.models.ProductsApi;
import com.procesos.primerprevio_procesos.services.ProductsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

@RestController
public class ProductsController {
    private final RestTemplate restTemplate;
    @Autowired
    public ProductsController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    private ProductsServiceImp productServiceImp;

    @GetMapping(value ="/product/{id}")
    public ResponseEntity findProductById(@PathVariable Long id){
        Map response = new HashMap();
        try{
            return new ResponseEntity(productServiceImp.getProducts(id), HttpStatus.OK);
        }catch(Exception e){
            response.put("status", "404");
            response.put("message","No se encontró el producto.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/saveProducts")
    public List<ProductsApi> saveProducts() {
        String url="https://fakestoreapi.com/products/";
        ProductsApi productsApi = restTemplate.getForObject(url, ProductsApi.class);
        for (Products products : productsApi.getProducts()) {

            Boolean res = productServiceImp.saveProducts(products);
            Map response = new HashMap();
            if(res==true){
                System.out.println("Registrado");;
            }else{
                response.put("status", "400");
                response.put("message", "No se guardo el producto");
            }
        }
        return Arrays.asList(productsApi);
    }

    @GetMapping(value = "/products")
    public ResponseEntity findAll() {
        Map response = new HashMap();
        try {
            return new ResponseEntity(productServiceImp.allProducts(), HttpStatus.OK);
        } catch (Exception e) {
            response.put("status", "404");
            response.put("message", "No se encontró el producto");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
