package com.Ibm.dao;

import java.util.List;

import com.Ibm.dto.Products;

public interface ProductsDao {

	Products get(int productId);

	List<Products> list();

	boolean add(Products products);

	boolean update(Products products);

	boolean delete(Products products);


   List<Products> listActiveProducts();
   
   List<Products> listActiveProductsByCategory(int categoryId);
   List<Products> getLatestActiveProducts(int count);

}
