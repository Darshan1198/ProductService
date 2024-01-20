package com.scaler.productservicedecmwfeve;

import com.scaler.productservicedecmwfeve.models.Category;
import com.scaler.productservicedecmwfeve.models.Product;
import com.scaler.productservicedecmwfeve.respositories.CategoryRepository;
import com.scaler.productservicedecmwfeve.respositories.ProductRepository;
import com.scaler.productservicedecmwfeve.respositories.projection.ProductWithIdAndTitle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductservicedecmwfeveApplicationTests {

    private ProductRepository  productRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public  ProductservicedecmwfeveApplicationTests( ProductRepository productRepository, CategoryRepository  categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;

    }

//    @Test
    void contextLoads() {
    }

    @Test
    @Transactional
    @Commit
    void testQueries(){
        productRepository.findByTitleContaining("Darshan");
//        productRepository.deleteByTitle("Darshan");
//        List<Product> products = productRepository.something();

//        Collection<ProductWithIdAndTitle>  products1 = productRepository.somethingSomething();
//        for(ProductWithIdAndTitle product : products1){
//            System.out.println(product.getTitle()+" "+product.getId());
//        }

//        List<Product> products = productRepository.someSome2(105L);
//        for(Product product: products){
//            System.out.println(product.getTitle()+" "+ product.getDescription());
//        }

        Optional<Category>  categoryOrional  = categoryRepository.findById(52L);
        if(true){
            System.out.println("getting Products");
            Category category  = categoryOrional.get();
            List<Product> products2 = category.getProducts();
            products2.get(0).getImageUrl();
        }
    }

}
