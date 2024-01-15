package com.scaler.productservicedecmwfeve.controlleradvices;

import com.scaler.productservicedecmwfeve.dto.ArithmeticExceptionDto;
import com.scaler.productservicedecmwfeve.dto.ExceptionDto;
import com.scaler.productservicedecmwfeve.exception.ProductNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmeticExceptionDto> handleArithmeticException(){
//        return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); one way to do it
        ArithmeticExceptionDto  arithmeticExceptionDto = new ArithmeticExceptionDto();
        arithmeticExceptionDto.setMessage("Something went wrong");
        return  new ResponseEntity<>(arithmeticExceptionDto,HttpStatus.OK);
    }

    @ExceptionHandler(ProductNotExistsException.class)
    public  ResponseEntity<ExceptionDto> handleProductNotExistsException(ProductNotExistsException exception){

        ExceptionDto dto  = new ExceptionDto();
        dto.setMessage(exception.getMessage());
        return  new ResponseEntity<>(dto,HttpStatus.OK);

    }
}
