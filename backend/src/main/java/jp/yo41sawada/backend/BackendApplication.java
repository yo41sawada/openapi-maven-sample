package jp.yo41sawada.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		// System.setProperty("logging.level.root", "DEBUG");
		SpringApplication.run(BackendApplication.class, args);
	}

}
