package com.bootshop.site;

import org.junit.jupiter.api.Test;

import com.github.slugify.Slugify;

public class TestSlug {

	@Test
	public void testSlug() {
		String name = "Nike Air Max Up Shoe 23";
		Slugify slg = new Slugify();
		String result = slg.slugify(name);
		System.out.println(result);
	}
}
