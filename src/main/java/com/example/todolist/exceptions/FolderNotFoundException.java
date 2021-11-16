package com.example.todolist.exceptions;

public class FolderNotFoundException extends RuntimeException{
    public FolderNotFoundException (Long id){
        super("The item you are looking for is not stored in the database");
    }
}
