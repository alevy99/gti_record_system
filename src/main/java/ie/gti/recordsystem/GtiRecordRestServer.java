package ie.gti.recordsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class GtiRecordRestServer {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "web");
        SpringApplication app = new SpringApplication(GtiRecordRestServer.class);
        // Disable Tomcat based on active profile
//        app.setWebApplicationType(WebApplicationType.SERVLET);
        app.run(args);
//        SpringApplication.run(GtiRecordRestServer.class, args);
    }
}
