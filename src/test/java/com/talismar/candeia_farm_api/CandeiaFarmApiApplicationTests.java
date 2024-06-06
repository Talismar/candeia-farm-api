package com.talismar.candeia_farm_api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CandeiaFarmApiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void validateExceptions() {
		Assertions.assertThrows(Exception.class, () -> {

		});
	}

}
