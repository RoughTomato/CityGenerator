package citygenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
	System.out.println("Setting up...");
        SpringApplication.run(Application.class, args);
    }
}
