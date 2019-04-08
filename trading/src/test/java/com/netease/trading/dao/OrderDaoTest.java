package com.netease.trading.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.netease.trading.BaseTest;
import com.netease.trading.entity.Order;
import com.netease.trading.entity.Product;
import com.netease.trading.entity.User;

public class OrderDaoTest extends BaseTest {
	@Autowired
	private OrderDao orderDao;
	@Test
	@Ignore
	public void testInsertOrder() {
		Order order = new Order();
		Product product = new Product();
		User user = new User();
		user.setUserId(1L);
		product.setProductId(2L);
		order.setOrderTime(new Date());
		order.setOrderProduct(product);
		order.setOrderQuantity(15);
		order.setOrderPrice(12.5);
		int effectedNum = orderDao.insertOrder(order);
		assertEquals(1,effectedNum);
	}
	@Test
	@Ignore
	public void testUpdateOrder() {
		Order order = new Order();
		Product product = new Product();
		User user = new User();
		user.setUserId(1L);
		product.setProductId(2L);
		order.setOrderId(1L);
		order.setOrderTime(new Date());
		order.setOrderProduct(product);
		order.setOrderQuantity(15);
		order.setOrderPrice(13.5);
		int effectedNum = orderDao.updateOrder(order);
		assertEquals(1,effectedNum);
	}
	@Test
	@Ignore
	public void testQueryUserOrder(){
		List<Order> orderList = orderDao.queryUserOrder(1L);
		assertEquals(2, orderList.size());
	}
	
}
