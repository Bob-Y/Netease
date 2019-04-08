package com.netease.trading.web.productadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
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
