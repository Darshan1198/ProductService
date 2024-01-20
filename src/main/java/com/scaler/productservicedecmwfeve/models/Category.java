package com.scaler.productservicedecmwfeve.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.LifecycleState;

import java.util.List;

@Setter
@Getter
@Entity
public class Category  extends  BaseModel{
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "category", cascade = {CascadeType.REMOVE})//  being  mapped by  attribute called  as  category
    private List<Product> products;
    private   String  name;
}
