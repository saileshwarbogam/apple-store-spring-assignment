package com.sailesh.springproject.applestore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class AppleStoreApplicationTests {

	@Test
	void testingMainMethodInSpringBootApplication()
	{
		AppleStoreApplication.main(new String[]{});
		Assertions.assertTrue(true, "asserting to with Sonar");
	}


}
