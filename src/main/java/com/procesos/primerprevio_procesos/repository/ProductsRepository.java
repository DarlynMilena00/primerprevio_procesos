package com.procesos.primerprevio_procesos.repository;

import com.procesos.primerprevio_procesos.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Long> {
}
