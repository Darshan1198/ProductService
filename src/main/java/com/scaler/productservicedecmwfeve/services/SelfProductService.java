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

import java.util.List;
import java.util.Optional;

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
        Optional<Product>  productOptional  = productRepository.findById(1L);
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
            product.setCategory(categoryRepository.save(product.getCategory()));
        }
        else {
            product.setCategory(categoryOptional.get());
        }
        return   productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
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