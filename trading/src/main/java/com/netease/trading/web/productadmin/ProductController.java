package com.netease.trading.web.productadmin;

import com.netease.trading.dao.OrderDao;
import com.netease.trading.dao.ProductDao;
import com.netease.trading.dto.UserProduct;
import com.netease.trading.entity.Order;
import com.netease.trading.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductDao productDao;
	@Autowired
	private OrderDao orderDao;

	@RequestMapping(value = "/productAdd")
	public String shopOperation() {
		// 转发至商品添加页面
		return "productAdd";
	}

	@RequestMapping(value = "/shoplist")
	public String shopList() {
		// 转发至店铺列表页面
		return "shop/shoplist";
	}

}
