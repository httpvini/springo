package com.course.springo;

import com.course.springo.utils.FillUpDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringoApplication implements CommandLineRunner {

	@Autowired
	FillUpDatabase fillUpDatabase;

	public static void main(String[] args) {
		SpringApplication.run(SpringoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		fillUpDatabase.fillUp();
	}
}
