package com.scaler.productservicedecmwfeve.inheritanceDemo.joinedtable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "jt_user")
@Inheritance( strategy = InheritanceType.JOINED)

public class User {
    @Id
    private long id;
    private  String  name;
    private   String   email;
}
