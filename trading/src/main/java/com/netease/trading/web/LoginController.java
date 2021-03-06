package com.netease.trading.web;

import com.netease.trading.dto.LoginDto;
import com.netease.trading.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login.action", method = RequestMethod.POST)
    @ResponseBody
    private ModelMap login(@RequestBody LoginDto loginDto, HttpServletRequest request) {
        ModelMap modelMap = new ModelMap();
        int validate = userService.validate(loginDto.getUser(), loginDto.getPass());
        if (validate < 0) {
            modelMap.put("success", false);
            modelMap.put("errMsg", "wrong user or password");
            logger.info("用户登录失败");
        } else {
            modelMap.put("success", true);
            modelMap.put("userType", validate);
            HttpSession session = request.getSession();
            session.setAttribute("user", loginDto.getUser());
            logger.info("用户{}登录成功，userType:{}", loginDto.getUser(), validate);
        }
        return modelMap;
    }

    @RequestMapping(value = "logout.action", method = RequestMethod.GET)
    private String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        ModelMap modelMap = new ModelMap();
        modelMap.put("success", true);
        logger.info("用户登出成功");
        return "html/login";
    }

}
