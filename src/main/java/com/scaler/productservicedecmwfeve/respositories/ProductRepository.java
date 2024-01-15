package com.scaler.productservicedecmwfeve.respositories;

import com.scaler.productservicedecmwfeve.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> { //DAO
}
