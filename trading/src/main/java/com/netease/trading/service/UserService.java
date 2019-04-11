package com.netease.trading.service;

import com.netease.trading.entity.User;
import java.util.List;
public interface UserService {

    List<User> getUserList();

    int validate(String username, String pass);

}
