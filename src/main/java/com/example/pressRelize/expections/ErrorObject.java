package com.example.pressRelize.expections;

import lombok.Data;

import java.util.Date;


@Data
public class ErrorObject {
    private Integer StatusCode;
    private String MessageError;
    private Date ErrorTime;
}


