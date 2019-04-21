package com.netease.trading.web.useradmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netease.trading.entity.User;
import com.netease.trading.service.UserService;

@Controller
@RequestMapping("/useradmin")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value="/listuser",method = RequestMethod.GET)
	@ResponseBody
	private Map<String,Object> listUser() {
		Map<String,Object> modelMap = new HashMap<String,Object>();
		List<User> list = new ArrayList<User>();
		try {
			list = userService.getUserList();
			modelMap.put("rows",list);
			modelMap.put("total",list.size());
			logger.info("用户列表获取成功，列表长度：{}", list.size());
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("errMsg",e.toString());
			logger.error("用户列表获取失败");
		}
		return modelMap;
	}

}
