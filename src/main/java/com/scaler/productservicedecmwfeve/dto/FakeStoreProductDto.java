package com.scaler.productservicedecmwfeve.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class FakeStoreProductDto  {

    // we will pass the same atribute that are in  FakeStore APi is sending
    // this is the object we will recieve from  FakeStore
    private  Long  id;
    private String title;
    private double  price;
    private String category;
    private  String description;
    private  String image;

}
