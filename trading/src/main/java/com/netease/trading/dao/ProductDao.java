package com.netease.trading.dao;

import java.util.List;

import com.netease.trading.entity.Order;
import com.netease.trading.entity.Product;

public interface ProductDao {
	/**
	 * 新增product
	 * 
	 * @param product
	 * @return
	 */
	int insertProduct(Product product);

	/**
	 * 更新product
	 * 
	 * @param product
	 * @return
	 */
	int updateProduct(Product product);
	
	/**
	 * list product
	 * @return productList
	 */
	List<Product> queryProduct();
}
