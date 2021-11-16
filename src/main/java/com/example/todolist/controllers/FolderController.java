package com.example.todolist.controllers;

import com.example.todolist.repositories.FolderRepository;
import com.example.todolist.models.Folder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/add")
    public Folder createFolder(@RequestBody final Folder folder){
        return folderRepository.saveAndFlush(folder);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
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
