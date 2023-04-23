package com.inory.foodtrace.service;

import com.inory.foodtrace.entity.User;

/**
 * @author inory
 * @create 2021-07-21 18:43
 */
public interface UserService {

    User selectUserByNameAndPwd(String name, String password);

    User getUserInfo(Long id);

    void insertUser(User user);

}
