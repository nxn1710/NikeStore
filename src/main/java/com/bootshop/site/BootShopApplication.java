package com.bootshop.site;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.bootshop.site.entities", "com.bootshop.site"})
public class BootShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootShopApplication.class, args);
	}

}
