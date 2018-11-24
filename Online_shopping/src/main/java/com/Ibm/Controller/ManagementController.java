package com.Ibm.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.Ibm.dao.CategoryDao;
import com.Ibm.dao.ProductsDao;
import com.Ibm.dto.Category;
import com.Ibm.dto.Products;
import com.Ibm.utility.FileUploadUtility;
import com.Ibm.utility.ProductCodeGen;
import com.Ibm.validator.productsValidator;

@Controller
@RequestMapping(value = "/manage")
public class ManagementController {

	@Autowired
	private CategoryDao categoryDAO;

	@Autowired
	private ProductsDao productsDAO;

	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showmanageProducts(@RequestParam(name = "operation", required = false) String operation) {
		ModelAndView mv = new ModelAndView("Page");
		mv.addObject("title", "Manage Products");
		mv.addObject("userClickManageProducts", true);
		Products p = new Products();

		p.setSuplierid(1);
		p.setActive(true);
		mv.addObject("products", p);

		if (operation != null) {
			if (operation.equals("products")) {
				mv.addObject("message", "product Submitted Successfully...!");
			}
		}

		return mv;

	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("products") Products mProducts,
			BindingResult bindingResult, Model model, HttpServletRequest request) {
		mProducts.setCode(ProductCodeGen.getCode());
		System.out.println(mProducts);
		
		if(mProducts.getId()==0)
		{
		new productsValidator().validate(mProducts, bindingResult);
		}
		else
		{
			if(!mProducts.getFile().getOriginalFilename().equals(""))
			{
				new productsValidator().validate(mProducts, bindingResult);
			}
		}
		if (bindingResult.hasErrors()) {
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation failed for product Submision");

			return "Page";
		}

		logger.error(mProducts.toString());
		logger.debug(mProducts.getCode());
		if (mProducts.getId() == 0) {
			productsDAO.add(mProducts);
		} else {
			productsDAO.update(mProducts);
		}

		if (!mProducts.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProducts.getFile(), mProducts.getCode());
			System.out.println(mProducts);

		}

		return "redirect:/manage/products?operation=products";
	}

	@RequestMapping(value = "/products/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id) {
		Products products = productsDAO.get(id);

		boolean isActive = products.isActive();
		products.setActive(!products.isActive());
		productsDAO.update(products);
		System.out.println(products);
		return (isActive) ? "Product Dectivated Successfully!" + products.getId()
				: "Product Activated Successfully!" + products.getId();

	}

	@RequestMapping(value = "/{id}/products", method = RequestMethod.GET)
	public ModelAndView showEditProducts(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("Page");
		mv.addObject("title", "Manage Products");
		mv.addObject("userClickManageProducts", true);
		Products p = productsDAO.get(id);
		mv.addObject("products", p);
		return mv;
	}

	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDAO.list();

	}

}
