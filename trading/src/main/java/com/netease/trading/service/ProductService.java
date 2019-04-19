package com.netease.trading.service;

import com.netease.trading.dto.CartItemDto;
import com.netease.trading.dto.ProductExecution;
import com.netease.trading.entity.Product;

import java.util.List;

public interface ProductService {

	ProductExecution getProductList();

	
//	Product getProductById(long productId);

	ProductExecution addProduct(Product product);
			
	ProductExecution modifyProduct(Product product);

}

