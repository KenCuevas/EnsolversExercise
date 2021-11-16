package com.example.todolist.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "folders")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idfolder;
    private String name;

    @OneToMany(mappedBy = "folder")
    @JsonManagedReference
    private List<Task> task;

    public Folder() {
    }

    public List<Task> getTask() {
        return task;
    }

    public void setTask(List<Task> task) {
        this.task = task;
    }

    public Long getIdfolder() {
        return idfolder;
    }

    public void setIdfolder(Long id) {
        this.idfolder = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
