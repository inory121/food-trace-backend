package com.inory.foodtrace.service;

import com.inory.foodtrace.entity.Farm;

import java.util.List;

/**
 * @author inory
 * @create 2021-07-21 18:43
 */
public interface FarmService {

    void insertFarmInfo(Farm farm);

    Farm selectFarmInfo(String pigId);

    List<Farm> selectFarmInfo();

    int updateFarmInfo(Farm farm, String pigId);

    int updateFarmStateInfo(String salesInfoId, Integer state);

}
