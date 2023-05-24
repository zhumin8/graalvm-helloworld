package com.example.graalvmhelloworld;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledInNativeImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class GraalvmHelloWorldApplicationTests {
	// private RestTemplate restTemplate = new RestTemplate();
	@Autowired
	private TestRestTemplate restTemplate;
	private static final Log LOGGER = LogFactory.getLog(GraalvmHelloWorldApplicationTests.class);
	@Test
	void contextLoads() {
		LOGGER.info("fake test run!!");
	}

	@Test
	@DisabledInNativeImage
	void applicationBuilder() {
		SpringApplicationBuilder app =
				new SpringApplicationBuilder(GraalvmHelloWorldApplication.class).properties("server.port=8082");
		app.run();
		this.restTemplate.getForObject("http://localhost:8082/hello", String.class);
	}
}
