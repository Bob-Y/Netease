package com.netease.trading.service;

import com.netease.trading.dto.ProductExecution;
import com.netease.trading.entity.Product;

public interface ProductService {

	ProductExecution getProductList();

	ProductExecution addProduct(Product product);
			
	ProductExecution modifyProduct(Product product);

}

