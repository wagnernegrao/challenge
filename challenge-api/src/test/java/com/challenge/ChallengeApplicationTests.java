package com.challenge;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ChallengeApplicationTests {

	@Test
	void contextLoads() {
		ChallengeApplication application = new ChallengeApplication();
		assertNotNull(application);
	}

}
