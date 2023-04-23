package com.inory.foodtrace.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.inory.foodtrace.entity.Butcher;
import com.inory.foodtrace.mapper.ButcherMapper;
import com.inory.foodtrace.service.ButcherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author inory
 * @create 2021-07-29 14:43
 */
@Service
public class ButcherServiceImpl implements ButcherService {

    @Resource
    ButcherMapper butcherMapper;

    @Override
    public void insertButcherInfo(Butcher butcher) {
        butcherMapper.insert(butcher);
    }

    @Override
    public Butcher selectButcherInfo(String pigId) {
        return butcherMapper.selectOne(new QueryWrapper<Butcher>().eq("pigID", pigId));
    }

    @Override
    public List<Butcher> selectButcherInfo() {
        return butcherMapper.selectList(null);
    }

    @Override
    public int updateButcherInfo(Butcher butcher, String pigId) {
        return butcherMapper.update(butcher, new QueryWrapper<Butcher>().eq("pigId", pigId));
    }

    @Override
    public int updateSButcherStateInfo(String pigId, Integer state) {
        return butcherMapper.update(null, new UpdateWrapper<Butcher>().eq("pigId", pigId).set("state", state));
    }
}
