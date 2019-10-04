package hello;

import dataproviders.DevicesDataProvider;
import dataproviders.MongoDBDataProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {







        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigBeans.class);
        SpringApplication.run(Application.class, args);
    }
}
