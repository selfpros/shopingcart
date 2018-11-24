package com.Ibm.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Ibm.dao.ProductsDao;
import com.Ibm.dto.Products;

@Repository("productsDAO")
@Transactional
public class ProductsDaoImpl implements ProductsDao {

	@Autowired
	private SessionFactory factory;

	@Override
	public Products get(int productId) {
		try {
			return factory.getCurrentSession().get(Products.class, Integer.valueOf(productId));
		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}
	}

	@Override
	public List<Products> list() {
		return factory.getCurrentSession().createQuery("FROM Products", Products.class).getResultList();

	}

	@Override
	public boolean add(Products products) {
		try {

			factory.getCurrentSession().persist(products);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Products products) {
		try {

			factory.getCurrentSession().update(products);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean delete(Products products) {
		try {
			products.setActive(false);
			return this.update(products);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Products> listActiveProducts() {

		String selectActiveProducts = "FROM Products WHERE active=:active";

		return factory.getCurrentSession().createQuery(selectActiveProducts, Products.class)
				.setParameter("active", true).getResultList();

	}

	@Override
	public List<Products> listActiveProductsByCategory(int categoryId) {

		String selectActiveProductsByCategory = "FROM Products WHERE active=:active AND categoryId=:categoryId";
		return factory.getCurrentSession().createQuery(selectActiveProductsByCategory, Products.class)
				.setParameter("active", true).setParameter("categoryId", true).getResultList();

	}

	@Override
	public List<Products> getLatestActiveProducts(int count) {
		return factory.getCurrentSession().createQuery("FROM Products WHERE active=:active ORDER BY id", Products.class)
				.setParameter("active", true).setFirstResult(0).setMaxResults(0).getResultList();

	}

}
