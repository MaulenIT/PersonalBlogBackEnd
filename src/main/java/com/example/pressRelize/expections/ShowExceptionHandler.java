package com.example.pressRelize.expections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;


@ControllerAdvice
public class ShowExceptionHandler {

   @ExceptionHandler({PostNotFoundException.class})
    public ResponseEntity<ErrorObject> handlerPostNotFoundException (PostNotFoundException exception , WebRequest request){
        ErrorObject errorObject = new ErrorObject();
        errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorObject.setMessageError(exception.getMessage());
        errorObject.setErrorTime(new Date());
        return new ResponseEntity<ErrorObject>(errorObject , HttpStatus.NOT_FOUND);
    }
}
