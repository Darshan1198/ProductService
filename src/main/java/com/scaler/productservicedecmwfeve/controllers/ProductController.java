package com.scaler.productservicedecmwfeve.controllers;

import com.scaler.productservicedecmwfeve.commons.AuthenticationCommons;
import com.scaler.productservicedecmwfeve.dto.FakeStoreProductDto;
import com.scaler.productservicedecmwfeve.dto.GenericProductDto;
import com.scaler.productservicedecmwfeve.dto.Role;
import com.scaler.productservicedecmwfeve.dto.UserDto;
import com.scaler.productservicedecmwfeve.exception.ProductNotExistsException;
import com.scaler.productservicedecmwfeve.models.Product;
import com.scaler.productservicedecmwfeve.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    private ProductService productService;
    private AuthenticationCommons  authenticationCommons;
    private RestTemplate  restTemplate;

    @Autowired
    public ProductController(@Qualifier("selfProductService") ProductService productService, RestTemplate  restTemplate, AuthenticationCommons authenticationCommons){
        this.productService= productService;
        this.restTemplate  = restTemplate;
        this.authenticationCommons= authenticationCommons;
    }

    @GetMapping() // it just needs localhost:8080/products
    public ResponseEntity<List<Product>> getAllProduct(){  //getallproduct does not  need any parameter


//        UserDto userDto  = authenticationCommons.validateToken(token);
//        if(userDto== null){
//            return  new ResponseEntity<>(HttpStatus.FORBIDDEN);
//        }
//        boolean  isadmin  = false;
//
//        for( Role role: userDto.getRoles()){
//            if(role.getName().equals("ADMIN")){
//                isadmin  = true;
//                break;
//            }
//        }
//        if (!isadmin) return   new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        List<Product>  products = productService.getAllProducts();  // o p q
        List<Product> finalProduct = new ArrayList<>();
//        for( int  i =0; i <products.size(); i++) {
//            finalProduct.add(products.get(i));
//        }

        for(Product p:products){
            p.setTitle("Hello "+p.getTitle()); // modifying  o p q
            finalProduct.add(p);

        }
//
        ResponseEntity<List<Product>> response  = new ResponseEntity<>(finalProduct,HttpStatus.FORBIDDEN);
        return  response;
//        ResponseEntity<List<Product>> response = new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
//        return  response;
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

        return  productService.updateProduct(id, product);
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
