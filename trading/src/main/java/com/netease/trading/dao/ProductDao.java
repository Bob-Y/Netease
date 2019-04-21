package com.netease.trading.dao;

import java.util.List;

import com.netease.trading.dto.UserProduct;
import com.netease.trading.entity.Order;
import com.netease.trading.entity.Product;

public interface ProductDao {
	/**
	 * 新增product
	 * @param product
	 * @return int
	 */
	int insertProduct(Product product);

	/**
	 * 更新product
	 * @param product
	 * @return int
	 */
	int updateProduct(Product product);
	
	/**
	 * 查询所有product
	 * @return productList
	 */
	List<Product> queryProduct();

	/**
	 * 根据product_id查询单个product
	 * @param pid
	 * @return Product
	 */
	Product findById(Integer pid);

	/**
	 * 根据product_id查询单个product（包含是否已购买）
	 * @param pid
	 * @return UserProduct
	 */
	UserProduct findUserProductById(Integer pid);

	/**
	 * 根据product_id查询单个product（product_price为购买时价格）
	 * @param pid
	 * @return Product
	 */
	Product findBoughtById(Integer pid);

	/**
	 * 根据user_id查询所有product（是否购买）
	 * @param uid
	 * @return List<UserProduct>
	 */
	List<UserProduct> queryUserProduct(Integer uid);

	/**
	 * 根据user_id查询所有未购买的product
	 * @param uid
	 * @return List<Product>
	 */
	List<Product> queryUnBought(Integer uid);

	/**
	 * 根据product_id删除对应的product
	 * @param pid
	 * @return int
	 */
	int deleteProduct(Integer pid);
}
