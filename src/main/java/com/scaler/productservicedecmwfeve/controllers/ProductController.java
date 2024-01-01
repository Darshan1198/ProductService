package com.scaler.productservicedecmwfeve.controllers;

import com.scaler.productservicedecmwfeve.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    @GetMapping() // it just needs localhost:8080/products
    public List<Product> getAllProduct(){  //getallproduct does not  need any parameter
        return   new ArrayList<>();
    }

    @GetMapping("/{id}") //this  id should be  passed in the path variable
    public  Product  getSingleProduct(@PathVariable("id") Long id){  // id will be present in the  path of the  url{id}
        return  new Product();
    }

    @PostMapping()
    public Product addNewProduct(@RequestBody Product product){  // the attributes present in the details of the  product that is commin from request body
        Product p =  new Product();
        p.setTitle("A new product");
        return p;
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
