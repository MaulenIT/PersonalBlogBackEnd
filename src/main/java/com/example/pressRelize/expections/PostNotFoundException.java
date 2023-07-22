package com.example.pressRelize.expections;

public class PostNotFoundException extends RuntimeException{
    public PostNotFoundException(String exception){
        super(exception);
    }
}
