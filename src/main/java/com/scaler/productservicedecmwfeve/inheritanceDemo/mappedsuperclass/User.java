package com.scaler.productservicedecmwfeve.inheritanceDemo.mappedsuperclass;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public class User {
    private  String  name;
    private   String   email;
}
