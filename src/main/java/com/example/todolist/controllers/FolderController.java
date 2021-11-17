package com.example.todolist.controllers;

import com.example.todolist.exceptions.FolderNotFoundException;
import com.example.todolist.models.Task;
import com.example.todolist.repositories.FolderRepository;
import com.example.todolist.models.Folder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/todo/folders")
public class FolderController {
    @Autowired
    private FolderRepository folderRepository;

    @GetMapping("/all")
    List<Folder>getAll(){
        return folderRepository.findAll();
    }

    @GetMapping(path = "search/{id}")
    public Folder getFolder(@PathVariable Long id){
        return folderRepository.findById(id)
                .orElseThrow(() -> new FolderNotFoundException(id));
    }
    @PostMapping("/add")
    public ResponseEntity create(@Validated @RequestBody Folder folder){
        return ResponseEntity.ok(folderRepository.save(folder));
    }

    @PutMapping("updateFolder/{id}")
    public Folder updateFolder(@PathVariable Long id, @RequestBody Folder folder){
        Folder existingFolder = folderRepository.getById(id);
        BeanUtils.copyProperties(folder, existingFolder, "id");
        return folderRepository.saveAndFlush(existingFolder);
    }
    @DeleteMapping("/delete/{id}")
    void deleteFolder(@PathVariable Long id){
        folderRepository.deleteById(id);
    }
}
