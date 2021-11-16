package com.example.todolist.exceptions;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(Long id){
        super("The item you are looking for is not stored in the database");
    }
}
