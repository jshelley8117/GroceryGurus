package com.JERZ.GroceryGurus;

import org.springframework.boot.SpringApplication;

public class TestGroceryGurusApplication {

	public static void main(String[] args) {
		SpringApplication.from(GroceryGurusApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
