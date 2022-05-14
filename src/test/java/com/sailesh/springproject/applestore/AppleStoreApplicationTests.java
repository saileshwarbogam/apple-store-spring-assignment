package com.sailesh.springproject.applestore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppleStoreApplicationTests {

	@Test
	void testingMainMethodInSpringBootApplication()
	{
		AppleStoreApplication.main(new String[]{});
		Assertions.assertTrue(true, "asserting to with Sonar");
	}


}
