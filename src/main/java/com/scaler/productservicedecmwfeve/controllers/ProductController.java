package com.scaler.productservicedecmwfeve.controllers;

import com.scaler.productservicedecmwfeve.dto.FakeStoreProductDto;
import com.scaler.productservicedecmwfeve.dto.GenericProductDto;
import com.scaler.productservicedecmwfeve.exception.ProductNotExistsException;
import com.scaler.productservicedecmwfeve.models.Product;
import com.scaler.productservicedecmwfeve.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    private ProductService productService;

    @Autowired

    public ProductController(@Qualifier("selfProductService") ProductService productService){
        this.productService= productService;
    }



    @GetMapping() // it just needs localhost:8080/products
    public ResponseEntity<List<Product>> getAllProduct(){  //getallproduct does not  need any parameter
        ResponseEntity<List<Product>> response = new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
        return  response;
    }

    @GetMapping("/{id}") //this  id should be  passed in the path variable
    public  ResponseEntity<Product>  getSingleProduct(@PathVariable("id") Long id) throws ProductNotExistsException {  // id will be present in the  path of the  url{id}
//        int a= 1/0;
        return new ResponseEntity<>(productService.getSingleProduct(id), HttpStatus.OK) ;  //All the  business logic we have  where should it  present  is it  part of  controller No, it  should be in  service
    }

    @PostMapping()
    public Product addNewProduct(@RequestBody Product  product){  // the attributes present in the details of the  product that is commin from request body
        return productService.addNewProduct(product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id,@RequestBody Product product){
        return  new Product();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id" )Long id, @RequestBody GenericProductDto product){
        return   productService.replaceProduct(id, product);
    }

    @DeleteMapping("{id}")
    public void  deleteProduct(@PathVariable("id" )Long id){
    }

    @ExceptionHandler(ProductNotExistsException.class)
    public  ResponseEntity<Void> handleProductNotExistsException(){
        return   new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }


}
