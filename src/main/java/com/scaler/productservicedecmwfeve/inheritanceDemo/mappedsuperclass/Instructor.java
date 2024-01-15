package com.scaler.productservicedecmwfeve.inheritanceDemo.mappedsuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "ms_instructor")
public class Instructor extends User {
    @Id
    private long id;
    private   String favouriteStudent;
}
