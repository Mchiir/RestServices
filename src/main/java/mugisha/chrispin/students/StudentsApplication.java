package mugisha.chrispin.students;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentsApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudentsApplication.class, args);
    }
}
//http://localhost:8080/v3/api-docs
//localhost:8080/swagger-ui/
//http://localhost:8080/api/students // GET ALL
// To run from terminal: 'mvn spring-boot:run' (main class is identified by springboot)