package com.inory.foodtrace.service;

import com.inory.foodtrace.entity.Butcher;

import java.util.List;

/**
 * @author inory
 * @create 2021-07-21 18:43
 */
public interface ButcherService {

    void insertButcherInfo(Butcher butcher);

    Butcher selectButcherInfo(String pigId);

    List<Butcher> selectButcherInfo();

    int updateButcherInfo(Butcher butcher, String pigId);

    int updateSButcherStateInfo(String salesInfoId, Integer state);

}
