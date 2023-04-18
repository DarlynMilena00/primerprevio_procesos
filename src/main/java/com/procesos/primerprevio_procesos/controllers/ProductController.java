package com.procesos.primerprevio_procesos.controllers;

import com.procesos.primerprevio_procesos.models.Product;
import com.procesos.primerprevio_procesos.services.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductController {
    @Autowired
    private ProductServiceImp productServiceImp;

    @GetMapping(value ="/product/{id}")
    public ResponseEntity findProductById(@PathVariable Long id){
        Map response = new HashMap();
        try{
            return new ResponseEntity(productServiceImp.getProduct(id), HttpStatus.OK);
        }catch(Exception e){
            response.put("status", "404");
            response.put("message","No se encontró el producto.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/product")
    public ResponseEntity saveProduct(@RequestBody Product product){
        Map response = new HashMap();
        Boolean productResp = productServiceImp.createProduct(product);
        if(productResp == true){
            response.put("status", "201");
            response.put("message", "Se creo el producto");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        response.put("status","400");
        response.put("message","Hubo un error al crear el producto");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
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
