package com.bootshop.site;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.bootshop.site.entities.Product;
import com.bootshop.site.entities.User;
import com.bootshop.site.repositories.ProductRepository;
import com.bootshop.site.repositories.UserRespository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProductRespositoryTest {

	@Autowired
	private UserRespository repo;
	@Test
	public void test() {
		User pro = repo.getUserByEmail("nghiepnxde140022@fpt.edu.vn");
		System.out.println(pro);
		assertThat(pro.getEmail()).isNotNull();
	}
}
