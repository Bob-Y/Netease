package com.netease.trading.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.netease.trading.BaseTest;
import com.netease.trading.entity.Product;
import com.netease.trading.entity.User;

public class ProductDaoTest extends BaseTest {
@Autowired
private ProductDao productDao;
@Test
@Ignore
public void testInsertProduct() {
	Product product = new Product();
	User user = new User();
	user.setUserId(1L);
	product.setProductAbstract("bingo abstract");
	product.setProductTitle("bing title");
	product.setProductDetail("bing detail");
	product.setProductImgAddr("https://dfsf.jpg");
	product.setProductPrice(12.5);
	product.setProductStatus(1);
	product.setProductImgType(1);
	product.setProductUser(user);
	int effectedNum = productDao.insertProduct(product);
	assertEquals(1,effectedNum);
}
@Test
@Ignore
public void testUpdateProduct() {
	Product product = new Product();
	User user = new User();
	user.setUserId(2L);
	product.setProductAbstract("bingo abstract updated");
	product.setProductTitle("bing title updated");
	product.setProductImgAddr("https://updated.jpg");
	product.setProductUser(user);
	product.setProductId(1L);
	int effectedNum = productDao.updateProduct(product);
	assertEquals(1,effectedNum);
}
@Test
@Ignore
public void testQueryProduct() {
	List<Product> productList = productDao.queryProduct();
	assertEquals(5, productList.size());
}
}
