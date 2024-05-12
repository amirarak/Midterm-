package kg.alatoo.midterm.service;

import kg.alatoo.midterm.DTO.TaskDTO;
import kg.alatoo.midterm.DTO.UserDTO;
import kg.alatoo.midterm.entity.Task;
import kg.alatoo.midterm.entity.User;
import kg.alatoo.midterm.mappers.TaskMapper;
import kg.alatoo.midterm.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskMapper taskMapper;

    public List<TaskDTO> listAll() {
        List<Task> users = taskRepository.findAll();
        return users.stream()
                .map(taskMapper::taskToTaskDTO)
                .collect(Collectors.toList());
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