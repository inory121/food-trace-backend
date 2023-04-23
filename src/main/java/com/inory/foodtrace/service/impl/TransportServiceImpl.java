package com.inory.foodtrace.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.inory.foodtrace.entity.Transport;
import com.inory.foodtrace.mapper.TransportMapper;
import com.inory.foodtrace.service.TransportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author inory
 * @create 2021-07-29 14:43
 */
@Service
public class TransportServiceImpl implements TransportService {

    @Resource
    TransportMapper transportMapper;

    @Override
    public void insertTransportInfo(Transport transport) {
        transportMapper.insert(transport);
    }

    @Override
    public Transport selectTransportInfo(String transportID) {
        return transportMapper.selectOne(new QueryWrapper<Transport>().eq("transportID", transportID));
    }

    @Override
    public List<Transport> selectTransportInfo() {
        return transportMapper.selectList(null);
    }

    @Override
    public int updateTransportInfo(Transport transport, String transportID) {
        return transportMapper.update(transport, new QueryWrapper<Transport>().eq("transportID", transportID));
    }

    @Override
    public int updateTransportStateInfo(String transportID, Integer state) {
        return transportMapper.update(null, new UpdateWrapper<Transport>().eq("transportID", transportID).set("state", state));
    }
}
