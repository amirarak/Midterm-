package kg.alatoo.midterm.controllers;

import kg.alatoo.midterm.DTO.TaskDTO;
import kg.alatoo.midterm.entity.Task;
import kg.alatoo.midterm.entity.User;
import kg.alatoo.midterm.service.TaskService;
import kg.alatoo.midterm.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping
    public List<TaskDTO> getAllTasks() {
        return taskService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = taskService.get(id);
        return task != null ? ResponseEntity.ok(task) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        User user = task.getUser();
        if (user != null) {
            Long userId = user.getId();
            User fetchedUser = userService.getUserById(userId);
            if (fetchedUser != null) {
                task.setUser(fetchedUser);
                Task savedTask = taskService.save(task);
                return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
            }
        }
        return ResponseEntity.notFound().build();
    }



    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        User user = task.getUser();
        if (user != null) {
            Long userId = user.getId();
            User fetchedUser = userService.getUserById(userId);
            if (fetchedUser != null) {
                task.setUser(fetchedUser);
                task.setTaskId(id);
                Task updatedTask = taskService.save(task);
                return ResponseEntity.ok(updatedTask);
            }
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        Task existingTask = taskService.get(id);
        if (existingTask != null) {
            taskService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}