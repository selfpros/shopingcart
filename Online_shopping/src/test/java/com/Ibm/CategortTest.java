package com.Ibm;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Ibm.dao.CategoryDao;
import com.Ibm.dto.Category;

public class CategortTest {
	private static AnnotationConfigApplicationContext context;

	private static CategoryDao categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.Ibm.*");
		context.refresh();

		categoryDAO = (CategoryDao) context.getBean("categoryDAO");
	}

	@Test
	public void testAddCategory() {
		category = new Category();
		category.setName("Mobile");
		category.setDescription("It has a Good features...!");
		category.setImageURL("Motrola.PNG");

		assertEquals("Successfully added a category inside the table", true, categoryDAO.add(category));

	}

}
