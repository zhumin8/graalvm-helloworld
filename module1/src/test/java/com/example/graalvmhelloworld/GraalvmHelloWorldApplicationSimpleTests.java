package com.example.graalvmhelloworld;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
@SpringBootTest(
		webEnvironment = WebEnvironment.RANDOM_PORT,
		classes = {GraalvmHelloWorldApplication.class})
class GraalvmHelloWorldApplicationSimpleTests {
	@Value(value="${local.server.port}")
	private int port;
	private static final Log LOGGER = LogFactory.getLog(GraalvmHelloWorldApplicationSimpleTests.class);

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
		LOGGER.info("simple test running!!");

		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/hello",
				String.class)).contains("hello");

	}
}
