package com.scaler.productservicedecmwfeve.services;

import com.scaler.productservicedecmwfeve.dto.FakeStoreProductDto;
import com.scaler.productservicedecmwfeve.models.Category;
import com.scaler.productservicedecmwfeve.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class FakeStoreProductService implements  ProductService{

// this  FakeStoreProductService  by calling the  Fake store  API
// we are going  to create a  object of  rest client  to be  able  to call the  3rd party API
// how  to use the  rest templat  library if i have  a  object and if i call that object  behind the  scene
//    it is  going to call the  api Do you think we need multiple instance of that object just to make an api call ? NO
//    we can have  a single  instance of that,  may be  many classes with in my code base may wnt  to call the  3rd party API
//    having an  object that allows  you to make call on 3rd party APi is going ot be  a good thing
//    Having a bean(object  present in Application context)
//
    private  RestTemplate  restTemplate;
    @Autowired
    public  FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product  product  = new Product();
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setId(fakeStoreProductDto.getId());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageUrl(fakeStoreProductDto.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProductDto.getCategory());

        return product;
    }
    @Override
    public Product getSingleProduct(Long  id) {
        FakeStoreProductDto productDto = restTemplate.getForObject("https://fakestoreapi.com/products/1"+id,FakeStoreProductDto.class );

                // the  object that we  wil get  externally is this //output
        //           PRODUCT {
        //                id:1,
        //                title:'...',
        //                price:'...',
        //                category:'...',
        //                description:'...',
        //                image:'...'
        //            }  we dont have any object exactly like this, when  ever  we are  talking  externally that data type
        //  that is only there to call DTO  we will store the exact attributes in the FakeStoreDto
        return convertFakeStoreProductToProduct(productDto);
    }

}
