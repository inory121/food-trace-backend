package com.inory.foodtrace.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.inory.foodtrace.entity.Sale;
import com.inory.foodtrace.mapper.SaleMapper;
import com.inory.foodtrace.service.SaleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author inory
 * @create 2021-07-29 14:43
 */
@Service
public class SaleServiceImpl implements SaleService {

    @Resource
    SaleMapper saleMapper;

    @Override
    public void insertSaleInfo(Sale sale) {
        saleMapper.insert(sale);
    }

    @Override
    public Sale selectSaleInfo(String salesInfoId) {
        return saleMapper.selectOne(new QueryWrapper<Sale>().eq("salesInfoId", salesInfoId));
    }

    @Override
    public List<Sale> selectSaleInfo() {
        return saleMapper.selectList(null);
    }

    @Override
    public int updateSaleInfo(Sale sale, String salesInfoId) {
        return saleMapper.update(sale, new QueryWrapper<Sale>().eq("salesInfoId", salesInfoId));
    }

    @Override
    public int updateSaleStateInfo(String salesInfoId, Integer state) {
        return saleMapper.update(null, new UpdateWrapper<Sale>().eq("salesInfoId", salesInfoId).set("state", state));
    }
}
