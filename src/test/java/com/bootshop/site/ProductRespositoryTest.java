package com.bootshop.site;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.bootshop.site.entities.Product;
import com.bootshop.site.entities.User;
import com.bootshop.site.repositories.ProductRepository;
import com.bootshop.site.repositories.UserRespository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback
public class ProductRespositoryTest {

	@Autowired
	private ProductRepository repo;
	@Test
	public void test() {
//		List<Product> list = repo.getFindCustomProduct(1, 4 ,1, 1);
//		System.out.println(list.size());
	}
}
