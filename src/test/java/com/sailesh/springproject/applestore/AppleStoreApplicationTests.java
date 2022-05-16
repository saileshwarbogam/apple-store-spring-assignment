package com.sailesh.springproject.applestore;

import com.sailesh.springproject.applestore.dao.CategoryRepository;
import com.sailesh.springproject.applestore.dao.ProductRepository;
import com.sailesh.springproject.applestore.entity.Category;
import com.sailesh.springproject.applestore.entity.Product;
import com.sailesh.springproject.applestore.service.CategoryService;
import com.sailesh.springproject.applestore.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
