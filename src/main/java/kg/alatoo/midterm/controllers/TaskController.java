package kg.alatoo.midterm.controllers;

import kg.alatoo.midterm.entity.Task;
import kg.alatoo.midterm.entity.User;
import kg.alatoo.midterm.service.TaskService;
import kg.alatoo.midterm.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = taskService.get(id);
        return task != null ? ResponseEntity.ok(task) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        User user = task.getUser(); // Get user object from the task
        if (user != null) {
            Long userId = user.getId(); // Get user ID
            User fetchedUser = userService.getUserById(userId); // Fetch user by ID
            if (fetchedUser != null) {
                task.setUser(fetchedUser); // Set user in the task
                Task savedTask = taskService.save(task); // Save the task
                return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
            }
        }
        return ResponseEntity.notFound().build();
    }



    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        User user = task.getUser(); // Получаем объект пользователя из задачи
        if (user != null) {
            Long userId = user.getId(); // Получаем ID пользователя
            User fetchedUser = userService.getUserById(userId); // Получаем пользователя по ID
            if (fetchedUser != null) {
                task.setUser(fetchedUser); // Устанавливаем пользователя в задаче
                task.setTaskId(id); // Устанавливаем ID задачи
                Task updatedTask = taskService.save(task); // Сохраняем обновленную задачу
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