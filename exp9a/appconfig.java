import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Course course() {
        return new Course("Spring Framework");
    }

    @Bean
    public Student student() {
        // Injecting the Course bean into the Student bean
        return new Student(course());
    }
}