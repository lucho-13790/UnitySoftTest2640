package co.com.javeriana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import co.com.javeriana.repository.mongoRepository;

@ComponentScan({"Repository"})
@ComponentScan(value = "org.foo.path.baseFolder")
@EnableMongoRepositories (basePackageClasses = mongoRepository.class)

@SpringBootApplication

public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

}
