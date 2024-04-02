Link to the video demonstration: https://t.me/backendmidterm 



**Project: Task Manager Application**

**Description:**
This project is a Task Manager Application developed using Java with the Spring Boot framework. It provides functionalities for managing tasks and users within the system.

**Components:**
- **BootstrapData:** Initializes the application with sample data upon startup.
- **TaskController:** Manages endpoints related to tasks (e.g., creating, updating, deleting tasks).
- **UserController:** Manages endpoints related to users (e.g., creating, updating, deleting users).
- **TaskDTO:** Data Transfer Object for tasks.
- **UserDTO:** Data Transfer Object for users.
- **Task:** Entity class representing a task.
- **User:** Entity class representing a user.
- **TaskMapper:** Maps Task entities to TaskDTOs.
- **UserMapper:** Maps User entities to UserDTOs.
- **TaskRepository:** Repository interface for managing tasks in the database.
- **UserRepository:** Repository interface for managing users in the database.
- **TaskService:** Service class for performing CRUD operations on tasks.
- **UserService:** Service class for performing CRUD operations on users.
- **MidtermApplication:** Main application class.

**Instructions for Running:**
1. Clone the repository to your local machine.
2. Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
3. Configure the database settings in the `application.properties` file.
4. Run the application using the `MidtermApplication` class.

**Testing:**
- **TaskControllerTest:** Tests the endpoints and functionality of the TaskController class.
- **UserControllerTest:** Tests the endpoints and functionality of the UserController class.
- **TaskMapperTest:** Tests the mapping functionality of the TaskMapper class.
- **UserMapperTest:** Tests the mapping functionality of the UserMapper class.
- **TaskRepositoryTest:** Tests the functionality of the TaskRepository interface.
- **UserRepositoryTest:** Tests the functionality of the UserRepository interface.
- **MidtermApplicationTests:** Tests the context loading of the Spring Boot application.

**Technologies Used:**
- Java
- Spring Boot
- Spring Data JPA
- MapStruct
- H2 Database (for testing)
- PostgreSQL (for production)
- Lombok
- JUnit

**Note:** Ensure that you have Java and Maven installed on your machine before running the application.
