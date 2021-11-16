package com.example.todolist.controllers;

import com.example.todolist.models.Task;
import com.example.todolist.repositories.TaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/todo/task")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/all")
    List<Task>getAll(){
        return taskRepository.findAll();
    }
    @PostMapping("/add")
    public Task createTask(@RequestBody final Task task){
        return taskRepository.saveAndFlush(task);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteTask(@PathVariable Long id){
        taskRepository.deleteById(id);
    }
    @RequestMapping(value = "{id}", method  = RequestMethod.PUT)
    public Task updateFolder(@PathVariable Long id, @RequestBody Task task){
        Task existingTask = taskRepository.getById(id);
        BeanUtils.copyProperties(task, existingTask, "id");
        return taskRepository.saveAndFlush(existingTask);
    }
}
