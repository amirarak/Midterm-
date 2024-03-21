package kg.alatoo.midterm.service;

import kg.alatoo.midterm.entity.Task;
import kg.alatoo.midterm.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserService userService;
    public List<Task> listAll() {
        return taskRepository.findAll();
    }

    public List<Task> listByUser(Long id) {
        return taskRepository.findByUserId(id);
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public Task get(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}