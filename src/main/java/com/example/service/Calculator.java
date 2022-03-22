package com.example.service;



import java.util.Date;
import com.example.exception.InvalidArgumentException;

public class Calculator {
    public int compareDates(Date date1, Date date2) throws InvalidArgumentException {
        if(null == date1 || null==date2){
            throw new InvalidArgumentException("Arguments cannot be null");
        }
        return date1.compareTo(date2);
    }

}
