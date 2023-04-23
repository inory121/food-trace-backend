package com.inory.foodtrace.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.inory.foodtrace.entity.Farm;
import com.inory.foodtrace.mapper.FarmMapper;
import com.inory.foodtrace.service.FarmService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author inory
 * @create 2021-07-29 14:43
 */
@Service
public class FarmServiceImpl implements FarmService {

    @Resource
    FarmMapper farmMapper;

    @Override
    public void insertFarmInfo(Farm farm) {
        farmMapper.insert(farm);
    }

    @Override
    public Farm selectFarmInfo(String pigId) {
        return farmMapper.selectOne(new QueryWrapper<Farm>().eq("pigID", pigId));
    }

    @Override
    public List<Farm> selectFarmInfo() {
        return farmMapper.selectList(null);
    }

    @Override
    public int updateFarmInfo(Farm farm, String pigId) {
        return farmMapper.update(farm, new QueryWrapper<Farm>().eq("pigId", pigId));
    }

    @Override
    public int updateFarmStateInfo(String pigId, Integer state) {
        return farmMapper.update(null, new UpdateWrapper<Farm>().eq("pigId", pigId).set("state", state));
    }

}
