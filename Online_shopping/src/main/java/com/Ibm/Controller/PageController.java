package com.Ibm.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Ibm.dao.CategoryDao;
import com.Ibm.dao.ProductsDao;
import com.Ibm.dto.Category;
import com.Ibm.dto.Products;
import com.Ibm.exception.ProductNotFoundException;

import javassist.bytecode.stackmap.BasicBlock.Catch;

@Controller
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	@Autowired
	private CategoryDao categoryDAO;

	@Autowired
	private ProductsDao productsDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("Page");

		mv.addObject("title", "Home");

		logger.info("Inside PageController index method-INFO");
		logger.info("Inside Page Controller index method-DEBUG");

		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);

		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("Page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("Page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}

	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {

		ModelAndView mv = new ModelAndView("Page");
		mv.addObject("title", "All Products");

		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts", true);
		return mv;

	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {

		ModelAndView mv = new ModelAndView("Page");

		// categorydao to fetch a single category
		Category category = null;
		category = categoryDAO.get(id);

		mv.addObject("title", category.getName());
		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		// passing the single object
		mv.addObject("category", category);

		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}

	@RequestMapping(value = "/show/{id}/products")
	public ModelAndView showSingleProduct(@PathVariable("id") int id) throws ProductNotFoundException {
		ModelAndView mv = new ModelAndView("Page");
		Products products = productsDAO.get(id);
		if (products == null){
			System.out.println("inside showsingleproduct");
			throw new ProductNotFoundException();
		}
		products.setViews(products.getViews() + 1);
		productsDAO.update(products);
		mv.addObject("title", products.getName());
		mv.addObject("products", products);
		System.out.println("value of products is:" + products);
		mv.addObject("userClickShowProduct", true);

		return mv;
	}

}
