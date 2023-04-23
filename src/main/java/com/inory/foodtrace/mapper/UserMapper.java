package com.inory.foodtrace.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inory.foodtrace.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author inory
 * @create 2021-07-21 18:40
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
