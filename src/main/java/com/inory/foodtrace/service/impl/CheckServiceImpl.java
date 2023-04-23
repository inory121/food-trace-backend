package com.inory.foodtrace.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.inory.foodtrace.entity.Check;
import com.inory.foodtrace.mapper.CheckMapper;
import com.inory.foodtrace.service.CheckService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author inory
 * @create 2021-08-13 0:06
 */
@Service
public class CheckServiceImpl implements CheckService {

    @Resource
    CheckMapper checkMapper;

    @Override
    public List<Check> selectCheck() {
        return checkMapper.selectList(null);
    }

    @Override
    public int insertCheck(Check check) {
        return checkMapper.insert(check);
    }

    @Override
    public int updateCheck(String checkId, Integer state) {
        return checkMapper.update(null, new UpdateWrapper<Check>().eq("checkID", checkId).set("state", state));
    }

    @Override
    public int selectCheck(String id) {
        return checkMapper.selectOne(new QueryWrapper<Check>().eq("id", id)).getState();
    }
}
