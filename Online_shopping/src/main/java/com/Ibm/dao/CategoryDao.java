package com.Ibm.dao;

import java.util.List;

import com.Ibm.dto.Category;

public interface CategoryDao {

	Category get(int id);

	List<Category> list();

	boolean add(Category category);

	boolean update(Category category);

	boolean delete(Category category);

}
