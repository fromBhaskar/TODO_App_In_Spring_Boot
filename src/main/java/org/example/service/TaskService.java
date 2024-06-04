package org.example.service;

import org.example.model.Task;

import java.util.Collection;

public interface TaskService {
    void createTask(Task task);
    void updateTask(String taskId,Task task);
    void deleteTask(String taskId);
    Collection<Task> getAllTasks();
    Task getTask(String taskId);
}
