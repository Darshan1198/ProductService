package com.scaler.productservicedecmwfeve.inheritanceDemo.mappedsuperclass;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ms_user")
public class Mentor extends User {
    @Id
    private   long id;
    private   double  avgRating;
}
