package com.scaler.productservicedecmwfeve.services;

import com.scaler.productservicedecmwfeve.dto.FakeStoreProductDto;
import com.scaler.productservicedecmwfeve.dto.GenericProductDto;
import com.scaler.productservicedecmwfeve.exception.ProductNotExistsException;
import com.scaler.productservicedecmwfeve.models.Category;
import com.scaler.productservicedecmwfeve.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    private FakeStoreProductDto productToFakestoreProduct(GenericProductDto product){
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setImage(product.getImage());
        fakeStoreProductDto.setCategory(product.getTitle());
        return fakeStoreProductDto;
    }
    @Override
    public Product getSingleProduct(Long  id)  throws ProductNotExistsException{
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
        if(productDto ==null){
            throw new ProductNotExistsException(
                    "Product"+id+"doesn't exists");

        }
        return convertFakeStoreProductToProduct(productDto);
    }

    @Override
    public FakeStoreProductDto addNewProduct(GenericProductDto product) {
        GenericProductDto productDto  = restTemplate.postForObject("https://fakestoreapi.com/products",product,GenericProductDto.class);
        return productToFakestoreProduct(productDto);

    }


    @Override
    public List<Product> getAllProducts(){

//        List<FakeStoreProductDto> response =  restTemplate.getForObject("https://fakestoreapi.com/products",List<FakeStoreProductDto>.class); //type erasure
//        List<FakeStoreProductDto> response =  restTemplate.getForObject("https://fakestoreapi.com/products",List.class); // just because  run  time will not know  what is the  type of object
        FakeStoreProductDto[] response = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        List<Product> answer  = new ArrayList<>();
        for(FakeStoreProductDto dto: response){
            answer.add(convertFakeStoreProductToProduct(dto));
        }
        return answer;

    }

    @Override
    public Product replaceProduct(Long id, GenericProductDto product) {
//        restTemplate.put();  this is  void type so we need  to deep into low level stuff  put internally uses exchange
//        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
//        HttpMessageConverterExtractor<T> responseExtractor = new HttpMessageConverterExtractor(responseType,getMessageConverters(),logger);
//        return restTemplate.execute("https://fakestoreapi.com/products/" +id, HttpMethod.PUT, requestCallback, responseExtractor,new HashMap<String, String >());
        RequestCallback requestCallback =restTemplate.httpEntityCallback(new FakeStoreProductDto(), FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDto.class, restTemplate.getMessageConverters());
        FakeStoreProductDto  response  = restTemplate.execute("https://fakestoreapi.com/products/"+ id, HttpMethod.POST, requestCallback, responseExtractor,new Object[]{});
        return convertFakeStoreProductToProduct(response);
    }


}
