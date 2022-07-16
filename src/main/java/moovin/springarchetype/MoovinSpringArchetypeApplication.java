package moovin.springarchetype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:environment.properties")
public class MoovinSpringArchetypeApplication {

  public static void main(String[] args) {
    SpringApplication.run(MoovinSpringArchetypeApplication.class, args);
  }

}
