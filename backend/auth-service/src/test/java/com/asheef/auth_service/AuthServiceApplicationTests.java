package com.asheef.auth_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
		"spring.cloud.gateway.enabled=false"
})
class AuthServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
