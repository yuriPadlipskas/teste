package br.com.fiap.gs1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"br.com.fiap.gs1.controllers, br.com.fiap.gs1.config"})
public class Gs1Application {

	public static void main(String[] args) {
		SpringApplication.run(Gs1Application.class, args);
	}

}
