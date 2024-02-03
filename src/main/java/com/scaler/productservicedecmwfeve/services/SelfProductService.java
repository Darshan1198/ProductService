package com.scaler.productservicedecmwfeve.services;

import com.scaler.productservicedecmwfeve.dto.FakeStoreProductDto;
import com.scaler.productservicedecmwfeve.dto.GenericProductDto;
import com.scaler.productservicedecmwfeve.exception.ProductNotExistsException;
import com.scaler.productservicedecmwfeve.models.Category;
import com.scaler.productservicedecmwfeve.models.Product;
import com.scaler.productservicedecmwfeve.respositories.CategoryRepository;
import com.scaler.productservicedecmwfeve.respositories.ProductRepository;
import lombok.Setter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Primary
@Service("selfProductService")
public class SelfProductService implements  ProductService{
    private  ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    private   SelfProductService(ProductRepository productRepository,CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getSingleProduct(Long id) throws ProductNotExistsException {
        Optional<Product>  productOptional  = productRepository.findById(id);
        if(productOptional.isEmpty()){ // this is  asically to check  is  some thing  exist in the  optional  or not
                        throw  new  ProductNotExistsException("Product With id :"+ id + "doesn't  exixt  exception");
        }
        Product product = productOptional.get();
        return   product;


    }

    @Override
    public Product addNewProduct(Product product) {
        Category  category  = product.getCategory();
        if( category.getId() == null) {
            Category savedCategor = categoryRepository.save(category);
            product.setCategory(savedCategor);
        }
        Optional<Category> categoryOptional  = categoryRepository.findByName(product.getCategory().getName());
        if(categoryOptional.isEmpty()){
//            product.setCategory(categoryRepository.save(product.getCategory()));
        }
        else {
            product.setCategory(categoryOptional.get());
        }
        return   productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<Product>  productOptional = productRepository.findById(id);
        if(productOptional.isEmpty()){
            throw  new RuntimeException();
        }
        Product savedProduct = productOptional.get();//this is the  product that is  actually saved
        if(product.getTitle()!= null){
            savedProduct.setTitle(product.getTitle());
        }
        if(product.getDescription()!=null){
            savedProduct.setDescription(product.getDescription());
        }
        if(product.getPrice()!= null){
            savedProduct.setPrice(product.getPrice());
        }
        if( product.getImageUrl()!=null){
            savedProduct.setImageUrl(product.getImageUrl());
        }
        return productRepository.save(savedProduct);
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList  = productRepository.getAllProduct();
        return   productList;

    }

    @Override
    public boolean deleteProduct(Long id) {
        return false;
    }

    @Override
    public Product replaceProduct(Long id, GenericProductDto product) {
        return null;
    }
}
