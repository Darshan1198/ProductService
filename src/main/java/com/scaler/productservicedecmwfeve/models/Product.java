package com.scaler.productservicedecmwfeve.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//insted  of  making  public  getter and  setter  we  can use one of the  dependencies  at the  start of the  prject LOMBOK
@Getter //automatically all the getmethods  will be created
@Setter
@Entity
public class Product extends BaseModel {

    private  String title;
    private  String description;
    private  Double price;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private  Category category;
    private  String imageUrl;
    private  int numberOfSales;
}
