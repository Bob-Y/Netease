package com.netease.trading.service;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.netease.trading.BaseTest;
import com.netease.trading.dto.ProductExecution;
import com.netease.trading.entity.Product;
import com.netease.trading.entity.User;
import com.netease.trading.enums.ProductStateEnum;

public class ProductServiceTest extends BaseTest {
	@Autowired
	private ProductService productService;
	
	@Test
	@Ignore
	public void testInsertProduct() {
		Product product = new Product();
		User user = new User();
		user.setUserId(1L);
		product.setProductAbstract("create by service");
		product.setProductTitle("bing title");
		product.setProductDetail("bing detail");
		product.setProductImgAddr("https://dfsf.jpg");
		product.setProductPrice(12.5);
		product.setProductStatus(1);
		product.setProductImgType(1);
		product.setProductUser(user);
		ProductExecution pe = productService.addProduct(product);
		assertEquals(ProductStateEnum.SUCCESS.getState(), pe.getState());
	}
	@Test
	@Ignore
	public void testUpdateProduct() {
		Product product = new Product();
		User user = new User();
		user.setUserId(2L);
		product.setProductAbstract("updated by service");
		product.setProductTitle("bing title updated");
		product.setProductImgAddr("https://updated.jpg");
		product.setProductUser(user);
		product.setProductId(3L);
		ProductExecution pe = productService.modifyProduct(product);
		assertEquals(ProductStateEnum.SUCCESS.getState(), pe.getState());
	}
//	@Test
////	@Ignore
//	public void testQueryProduct() {
//		ProductExecution pe = productService.getProductList();
//		System.out.println("总数为：" + pe.getCount());
//		assertEquals(ProductStateEnum.SUCCESS.getState(), pe.getState());
//	}

}
