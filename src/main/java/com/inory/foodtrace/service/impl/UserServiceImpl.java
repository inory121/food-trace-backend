package com.inory.foodtrace.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.inory.foodtrace.entity.User;
import com.inory.foodtrace.mapper.UserMapper;
import com.inory.foodtrace.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author inory
 * @create 2021-07-21 19:04
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public User selectUserByNameAndPwd(String name, String password) {
        return userMapper.selectOne(new QueryWrapper<User>().eq("name", name).eq("password", password));
    }

    @Override
    public User getUserInfo(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insert(user);
    }

}
