package com.scaler.productservicedecmwfeve.services;

import com.scaler.productservicedecmwfeve.dto.FakeStoreProductDto;
import com.scaler.productservicedecmwfeve.dto.GenericProductDto;
import com.scaler.productservicedecmwfeve.exception.ProductNotExistsException;
import com.scaler.productservicedecmwfeve.models.Product;
import com.scaler.productservicedecmwfeve.respositories.CategoryRepository;
import com.scaler.productservicedecmwfeve.respositories.ProductRepository;
import lombok.Setter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public FakeStoreProductDto addNewProduct(GenericProductDto product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, GenericProductDto product) {
        return null;
    }
}
