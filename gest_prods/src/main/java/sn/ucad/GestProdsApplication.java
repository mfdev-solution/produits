package sn.ucad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication
public class GestProdsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestProdsApplication.class, args);
	}

}
