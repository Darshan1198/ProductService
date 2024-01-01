package com.scaler.productservicedecmwfeve.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// HelloController  class  will have  multiple methods that  will be  serving  HTP request  at /hello
// this  class  will be  service  Rest(HTTP) APIS
// localhost:8080/hello
@RestController
@RequestMapping("/hello")
public class HelloController {

    //  /hello can  contains multiple method
    // GET/hello/say

    @GetMapping("/say/{name}/{times}")
    public  String  sayHello(@PathVariable("name") String name,
                             @PathVariable("times") int  times){

        String  answer  ="";
        for(int i =0; i< times; i++){
            answer += "Hello "+ name;
            answer += "</br>";
        }
        return answer;
        // when you put something in  curly braces becomes a variables

    }

}
