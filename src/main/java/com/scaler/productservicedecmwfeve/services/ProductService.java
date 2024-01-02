package com.scaler.productservicedecmwfeve.services;

import com.scaler.productservicedecmwfeve.dto.FakeStoreProductDto;
import com.scaler.productservicedecmwfeve.dto.GenericProductDto;
import com.scaler.productservicedecmwfeve.models.Product;

public interface ProductService {
    Product getSingleProduct(Long  id);

    FakeStoreProductDto addNewProduct(GenericProductDto product);
}
