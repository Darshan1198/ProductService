package com.scaler.productservicedecmwfeve.controllers;

import com.scaler.productservicedecmwfeve.dto.FakeStoreProductDto;
import com.scaler.productservicedecmwfeve.dto.GenericProductDto;
import com.scaler.productservicedecmwfeve.models.Product;
import com.scaler.productservicedecmwfeve.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService= productService;
    }




    @GetMapping() // it just needs localhost:8080/products
    public List<Product> getAllProduct(){  //getallproduct does not  need any parameter
        return   productService.getAllProducts();
    }

    @GetMapping("/{id}") //this  id should be  passed in the path variable
    public  Product  getSingleProduct(@PathVariable("id") Long id){  // id will be present in the  path of the  url{id}
        return  productService.getSingleProduct(id);  //All the  business logic we have  where should it  present  is it  part of  controller No, it  should be in  service
    }

    @PostMapping()
    public FakeStoreProductDto addNewProduct(@RequestBody GenericProductDto genericProduct){  // the attributes present in the details of the  product that is commin from request body
        return productService.addNewProduct(genericProduct);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id,@RequestBody Product product){
        return  new Product();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id" )Long id, @RequestBody Product product){
        return   new Product();
    }

    @DeleteMapping("{id}")
    public void  deleteProduct(@PathVariable("id" )Long id){
    }

}
