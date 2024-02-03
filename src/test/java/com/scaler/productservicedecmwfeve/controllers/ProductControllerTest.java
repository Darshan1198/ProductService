package com.scaler.productservicedecmwfeve.controllers;

import com.scaler.productservicedecmwfeve.exception.ProductNotExistsException;
import com.scaler.productservicedecmwfeve.models.Product;
import com.scaler.productservicedecmwfeve.respositories.ProductRepository;
import com.scaler.productservicedecmwfeve.services.ProductService;
import com.scaler.productservicedecmwfeve.services.SelfProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;


@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController  productController;


    @MockBean
//    @Qualifier("service")
    private SelfProductService productService;

    @MockBean
    private ProductRepository productRepository;





    @Test
    void  testProductSameService(){


        //arrange
        List<Product> products = new ArrayList<>();
        Product  p1  = new Product();  //o
        p1.setTitle( "Iphone  15");
        products.add(p1);

        Product  p2  = new Product();  //p
        p1.setTitle( "Iphone  14");
        products.add(p1);

        Product  p3  = new Product();  //q
        p1.setTitle( "Iphone  13");
        products.add(p1);

        List<Product>  productToPass  = new ArrayList<>();
        for(Product  p: products){
            Product  p11  = new Product();
            p11.setTitle(p.getTitle());
            productToPass.add(p11);
        }
        when(
                productService.getAllProducts()
        ).thenReturn(
                productToPass
        );

        //act
        ResponseEntity<List<Product>> response  = productController.getAllProduct();

        //assert
        List<Product>  productInResponse   = response.getBody();

//        assertEquals(products.size(),productInResponse.size());


        for( int i =0; i<productInResponse.size();i++){
            assertEquals(products.get(i).getTitle(),//  o p q
                    productInResponse.get(i).getTitle() );

        }

    }


    @Test
    void  getNotExistingProductException() throws ProductNotExistsException {

        //arrange
        // here  if product repository does not contain any thing  then only it will throw the  error
//        we need  to create the  mock bean  of product reposiotry

        when(
                productRepository.findById(10L)
        ).thenReturn(Optional.empty()
        );

        when(
                productService.getSingleProduct(any())
        ).thenCallRealMethod();

        //act
        assertThrows(ProductNotExistsException.class, () ->productController.getSingleProduct(10L));


    }




}