package com.scaler.productservicedecmwfeve.dto;


import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Setter
@Getter
public class UserDto {
    private String  name;
    private String  email;
    private List<Role> roles;
    private boolean isEmailVerified;

}
