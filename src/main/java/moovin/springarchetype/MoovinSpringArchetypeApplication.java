package moovin.springarchetype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableEurekaClient
@PropertySource("classpath:environment.properties")
public class MoovinSpringArchetypeApplication {

  public static void main(String[] args) {
    SpringApplication.run(MoovinSpringArchetypeApplication.class, args);
  }

}
