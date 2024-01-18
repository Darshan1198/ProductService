package com.scaler.productservicedecmwfeve.respositories;

import com.scaler.productservicedecmwfeve.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> { //DAO

    List<Product> findByTitleContaining(String word);

    long deleteByTitle(String title);

    // we need  to query for you are given the  category id you have to find the  product
    //  whose  category is with  that id
    List<Product> findByCategory_Id(Long id);

    //GetAllProductapi


    //to get the single profuct
    Optional<Product> findById(Long  id);

    Product save(Product product);

}
