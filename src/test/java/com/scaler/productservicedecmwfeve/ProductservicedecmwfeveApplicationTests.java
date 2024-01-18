package com.scaler.productservicedecmwfeve;

import com.scaler.productservicedecmwfeve.respositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class ProductservicedecmwfeveApplicationTests {

    private ProductRepository  productRepository;
    @Autowired
    public  ProductservicedecmwfeveApplicationTests( ProductRepository productRepository){
        this.productRepository = productRepository;
    }

//    @Test
    void contextLoads() {
    }

//    @Test
    @Transactional
    @Commit
    void testQueries(){
        productRepository.findByTitleContaining("Darshan");

        productRepository.deleteByTitle("Darshan");

    }

}
