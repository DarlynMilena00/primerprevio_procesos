package com.procesos.primerprevio_procesos.repository;

import com.procesos.primerprevio_procesos.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
