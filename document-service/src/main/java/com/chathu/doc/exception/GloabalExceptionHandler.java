package com.chathu.doc.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GloabalExceptionHandler{

    @Autowired
    ExceptionResponse exceptionResponse;


    @ExceptionHandler(DocumentException.class)
    public ResponseEntity<ExceptionResponse> serviceExceptionHandler(DocumentException e){
        exceptionResponse.setErrorCode("Error-0010");
        exceptionResponse.setErrorMessage(e.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
