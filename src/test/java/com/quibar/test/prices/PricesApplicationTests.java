package com.quibar.test.prices;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.quibar.test.prices.infra.api.PriceController;

@SpringBootTest
class PricesApplicationTests {

	@Autowired
	PriceController controller;
	
	@Test
	void contextLoads(ApplicationContext context) {
		assertNotNull(context);
		assertNotNull(controller);
	}
	

}
