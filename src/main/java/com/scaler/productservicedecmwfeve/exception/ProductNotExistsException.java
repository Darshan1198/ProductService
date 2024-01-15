package com.scaler.productservicedecmwfeve.exception;

import org.apache.logging.log4j.message.Message;

public class ProductNotExistsException  extends Exception{
    public  ProductNotExistsException (String message){
        super(message);
    }
}
