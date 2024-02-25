package com.scaler.productservicedecmwfeve.commons;

import com.scaler.productservicedecmwfeve.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthenticationCommons {
    private RestTemplate restTemplate;

    public AuthenticationCommons( RestTemplate  restTemplate){
        this.restTemplate = restTemplate;
    }

    public  UserDto validateToken(String  token){

        ResponseEntity<UserDto> userDtoResponse = restTemplate.postForEntity("http://loalhost:8080/users/validate/"+ token,null, UserDto.class );

        if( userDtoResponse.getBody() ==null){
            return   null;   //false
        }

        return userDtoResponse.getBody(); // true

    }
}
