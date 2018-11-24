package com.Ibm;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Ibm.dao.ProductsDao;
import com.Ibm.dto.Products;

public class ProductsTestCase {

	private static AnnotationConfigApplicationContext context;

	private static ProductsDao productsDAO;

	private static Products products;

	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.Ibm.*");
		context.refresh();
		productsDAO=(ProductsDao) context.getBean("productsDAO");
	}
		
		@Test
		public void testCurdProduct()
		{
			products=new Products();
			products.setCode("PRDABCXYZDEFX");	
			products.setName("Dell Latitude3460");
			products.setBrand("Dell");
			products.setDescription("128gb Memory And 4gb Ram and 17.5mm screen more Extra features...!");
			products.setQuantity(2);
			products.setActive(true);
			products.setUnitPrice(20000);
			products.setCategoryId(6);
			products.setSuplierid(6);
			assertEquals("Successfully added a category inside the table", true, productsDAO.add(products));

			
		}
		

}
