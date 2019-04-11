package com.netease.trading.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ViewController {

    @RequestMapping("/html/*")
    public String login(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        String result = requestURI.substring(requestURI.lastIndexOf("/"));
        return result;
    }
}
