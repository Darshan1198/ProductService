package com.scaler.productservicedecmwfeve.services;

import com.scaler.productservicedecmwfeve.dto.FakeStoreProductDto;
import com.scaler.productservicedecmwfeve.dto.GenericProductDto;
import com.scaler.productservicedecmwfeve.exception.ProductNotExistsException;
import com.scaler.productservicedecmwfeve.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long  id) throws ProductNotExistsException;

    FakeStoreProductDto addNewProduct(GenericProductDto product);

    List<Product> getAllProducts();

    Product  replaceProduct(Long  id,  GenericProductDto product);
}
