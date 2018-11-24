package com.Ibm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Ibm.dao.ProductsDao;
import com.Ibm.dto.Products;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	private ProductsDao productsDAO;

	@RequestMapping("/all/products")
	@ResponseBody
	public List<Products> getAllProducts() {
		return productsDAO.listActiveProducts();

	}

	@RequestMapping("/admin/all/products")
	@ResponseBody
	public List<Products> getAllProductsForAdmin() {
	    
	    List<Products> list = productsDAO.list ();
	    System.out.println("list of products "+list);
		return list;

	}

	@RequestMapping("/category/{id}/products")
	@ResponseBody

	public List<Products> getproductsByCategory(@PathVariable int id) {
		return productsDAO.listActiveProductsByCategory(id);

	}

}
