package com.scaler.productservicedecmwfeve.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

//insted  of  making  public  getter and  setter  we  can use one of the  dependencies  at the  start of the  prject LOMBOK
@Getter //automatically all the getmethods  will be created
@Setter
@Entity
public class Product extends BaseModel {

    private  String title;
    private  String description;
    private  double price;
    @ManyToOne
    private  Category category;
    private  String imageUrl;
}
