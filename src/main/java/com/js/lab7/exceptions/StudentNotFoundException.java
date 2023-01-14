package com.js.lab7.exceptions;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(long id){
        super("Nie ma studenta o podanym id:"+id);
    }
}
