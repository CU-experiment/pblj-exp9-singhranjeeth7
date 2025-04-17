import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        // Create the application context using AppConfig
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get the Student bean from the Spring context
        Student student = context.getBean(Student.class);

        // Call the method to display student details
        student.displayDetails();
    }
}