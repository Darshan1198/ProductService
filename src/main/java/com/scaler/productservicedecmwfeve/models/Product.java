package com.scaler.productservicedecmwfeve.models;


import lombok.Getter;
import lombok.Setter;

//insted  of  making  public  getter and  setter  we  can use one of the  dependencies  at the  start of the  prject LOMBOK
@Getter //automatically all the getmethods  will be created
@Setter
public class Product {
    private  Long id;
    private  String title;
    private  String description;
    private  double price;
    private  Category category;
    private  String imageUrl;
}
