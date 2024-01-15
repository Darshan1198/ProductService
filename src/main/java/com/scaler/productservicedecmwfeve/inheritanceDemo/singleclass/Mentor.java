package com.scaler.productservicedecmwfeve.inheritanceDemo.singleclass;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "1")
public class Mentor extends User {
    private   double  avgRating;
}
