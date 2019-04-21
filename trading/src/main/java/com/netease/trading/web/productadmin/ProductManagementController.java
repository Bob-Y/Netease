package com.netease.trading.web.productadmin;

import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netease.trading.dto.ProductExecution;
import com.netease.trading.entity.Product;
import com.netease.trading.enums.ProductStateEnum;
import com.netease.trading.exceptions.ProductOperationException;
import com.netease.trading.service.ProductService;
import com.netease.trading.util.HttpServletRequestUtil;

@Controller
@RequestMapping("/productadmin")
public class ProductManagementController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> addProduct(MultipartFile imgFile, HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 接收前端参数的变量的初始化，包括商品，缩略图，详情图列表实体类
		ObjectMapper mapper = new ObjectMapper();
		Product product = null;
		try {
			String productStr = HttpServletRequestUtil.getString(request, "productStr");
			// 尝试获取前端传过来的表单string流并将其转换成Product实体类
			product = mapper.readValue(productStr, Product.class);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
			return modelMap;
		}
		String realPath = request.getSession().getServletContext().getRealPath("/");
		String filePath = realPath + "resources/img/";
		if(imgFile != null) {
			String name = imgFile.getOriginalFilename();
			String suffix = name.substring(name.lastIndexOf("."));
			String random = UUID.randomUUID().toString();
			filePath = filePath + random + suffix;
			try {
				File file = new File(filePath);
				if (!file.exists()) {
					file.createNewFile();
				}
				imgFile.transferTo(file);
			} catch (IOException e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.toString());
				return modelMap;
			}
			product.setProductImgAddr("/trading/resources/img/" + random + suffix);
		}
		if (product != null ) {
			try {
				// 执行添加操作
				ProductExecution pe = productService.addProduct(product);
				if (pe.getState() == ProductStateEnum.SUCCESS.getState()) {
					modelMap.put("success", true);
				} else {
					modelMap.put("success", false);
					modelMap.put("errMsg", pe.getStateInfo());
				}
			} catch (ProductOperationException e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.toString());
				return modelMap;
			}
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "请输入商品信息");
		}
		return modelMap;
	}

	@RequestMapping(value = "/modifyproduct/{id}", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> modifyProduct(MultipartFile imgFile, HttpServletRequest request, @PathVariable Integer id) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 接收前端参数的变量的初始化，包括商品，缩略图，详情图列表实体类
		ObjectMapper mapper = new ObjectMapper();
		Product newProduct = null;
		try {
			String productStr = HttpServletRequestUtil.getString(request, "productStr");
			// 尝试获取前端传过来的表单string流并将其转换成Product实体类
			newProduct = mapper.readValue(productStr, Product.class);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
			return modelMap;
		}
		String realPath = request.getSession().getServletContext().getRealPath("/");
		String filePath = realPath + "resources/img/";
		if(imgFile != null) {
			String name = imgFile.getOriginalFilename();
			String suffix = name.substring(name.lastIndexOf("."));
			String random = UUID.randomUUID().toString();
			filePath = filePath + random + suffix;
			try {
				File file = new File(filePath);
				if (!file.exists()) {
					file.createNewFile();
				}
				imgFile.transferTo(file);
			} catch (IOException e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.toString());
				return modelMap;
			}
			newProduct.setProductImgAddr("/trading/resources/img/" + random + suffix);
		}
		if (newProduct != null ) {
			try {
				// 执行修改操作
				ProductExecution pe = productService.modifyProduct(newProduct);
				if (pe.getState() == ProductStateEnum.SUCCESS.getState()) {
					modelMap.put("success", true);
				} else {
					modelMap.put("success", false);
					modelMap.put("errMsg", pe.getStateInfo());
				}
			} catch (ProductOperationException e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.toString());
				return modelMap;
			}
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "请输入商品信息");
		}
		return modelMap;
	}

	@RequestMapping(value = "/getproductlist", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> getProductListByShop(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 传入查询条件以及分页信息进行查询，返回相应商品列表以及总数
		ProductExecution pe = productService.getProductList();
		modelMap.put("productList", pe.getProductList());
		modelMap.put("count", pe.getCount());
		modelMap.put("success", true);
		return modelMap;
	}

}
