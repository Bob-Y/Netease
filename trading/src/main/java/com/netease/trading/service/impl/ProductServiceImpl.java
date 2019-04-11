package com.netease.trading.service.impl;

import java.util.List;

import com.netease.trading.dao.OrderDao;
import com.netease.trading.dto.CartItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netease.trading.dao.ProductDao;
import com.netease.trading.dto.ProductExecution;
import com.netease.trading.entity.Product;
import com.netease.trading.enums.ProductStateEnum;
import com.netease.trading.exceptions.ProductOperationException;
import com.netease.trading.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	@Autowired
	private OrderDao orderDao;

	@Override
	public ProductExecution getProductList() {
		// 调用dao层取回商品列表
		List<Product> productList = productDao.queryProduct();
		// 基于同样的查询条件返回该查询条件下的商品总数
		int count = productList.size();
		ProductExecution pe = new ProductExecution();
		pe.setProductList(productList);
		pe.setCount(count);
		return pe;
	}

	
	@Override
	@Transactional
	public ProductExecution addProduct(Product product) {
		// 空值判断
		if (product != null) {
			try {
				// 创建商品信息
				int effectedNum = productDao.insertProduct(product);
				if (effectedNum <= 0) {
					throw new ProductOperationException("创建商品失败");
				}
			} catch (Exception e) {
				throw new ProductOperationException("创建商品失败:" + e.toString());
			}

			return new ProductExecution(ProductStateEnum.SUCCESS, product);
		} else {
			// 传参为空则返回空值错误信息
			return new ProductExecution(ProductStateEnum.EMPTY);
		}
	}

	@Override
	@Transactional
	public ProductExecution modifyProduct(Product product) throws ProductOperationException {
		// 空值判断
		if (product != null) {
			
			try {
				// 更新商品信息
				int effectedNum = productDao.updateProduct(product);
				if (effectedNum <= 0) {
					throw new ProductOperationException("更新商品信息失败");
				}
				return new ProductExecution(ProductStateEnum.SUCCESS, product);
			} catch (Exception e) {
				throw new ProductOperationException("更新商品信息失败:" + e.toString());
			}
		} else {
			return new ProductExecution(ProductStateEnum.EMPTY);
		}
	}

	@Override
	public boolean addOrder(List<CartItemDto> cart) {
		for(CartItemDto item: cart) {

		}

		return false;
	}


}

