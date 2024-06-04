package org.example.service;

import org.example.model.Task;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    public static HashMap<String, Task> taskRepo = new HashMap<String, Task>();

    static {

        taskRepo.put("1", new Task("1", "Bhaskar"));
        taskRepo.put("2", new Task("2", "Karan"));
    }

    @Override
    public void createTask(Task task) {
        taskRepo.put(task.taskId(),task);
    }

    @Override
    public void updateTask(String taskId, Task task) {
        taskRepo.put(taskId,task);
    }

    @Override
    public void deleteTask(String taskId) {
        taskRepo.remove(taskId);
    }

    @Override
    public Collection<Task> getAllTasks() {
        return  taskRepo.values();
    }

    @Override
    public Task getTask(String taskId) {
        return taskRepo.get(taskId);
    }
}
