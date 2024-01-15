package com.scaler.productservicedecmwfeve.inheritanceDemo.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name="jt_instructor")
@PrimaryKeyJoinColumn(name = "user_id")
public class Instructor extends User{
    private   String favouriteStudent;
}
