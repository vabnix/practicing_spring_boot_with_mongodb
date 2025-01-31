package com.vaibhav.spring;

import com.vaibhav.spring.configuration.OpenAPIConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testMain() {
		Application.main(new String[] {});
	}

	@Test
	void testOpenAPIConfiguration() {
		OpenAPIConfiguration openAPIConfiguration = new OpenAPIConfiguration();
		openAPIConfiguration.springOpenAPI();
	}

}
