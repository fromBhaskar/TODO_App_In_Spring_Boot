package org.example.controller;

import org.example.model.Task;
import org.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskServiceController {
    @Autowired
    TaskService taskService;

    @GetMapping(value ="/task")
    public ResponseEntity<Object> getAllTasks(){
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    @GetMapping(value = "/task/{id}")
    public ResponseEntity<Object> getTask(@PathVariable("id") String id){
        return new ResponseEntity<>(taskService.getTask(id),HttpStatus.OK);
    }

    @PutMapping(value = "/task/{id}")
    public ResponseEntity<Object> updateTask(@PathVariable("id") String id, @RequestBody Task task){
        taskService.updateTask(id,task);
        return new ResponseEntity<>("Task updated successfully",HttpStatus.OK);
    }

    @DeleteMapping(value = "/task/{id}")
    public ResponseEntity<Object> deleteTask(@PathVariable String id){
        taskService.deleteTask(id);
        return new ResponseEntity<>("Task deleted successfully",HttpStatus.OK);
    }

    @PostMapping(value = "/task")
    public ResponseEntity<Object> createTask(@RequestBody Task task){
        taskService.createTask(task);
        return new ResponseEntity<>("Task created successfully",HttpStatus.OK);
    }

}
