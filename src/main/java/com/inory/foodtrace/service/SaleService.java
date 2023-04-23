package com.inory.foodtrace.service;

import com.inory.foodtrace.entity.Sale;

import java.util.List;

/**
 * @author inory
 * @create 2021-07-21 18:43
 */
public interface SaleService {

    void insertSaleInfo(Sale sale);

    Sale selectSaleInfo(String salesInfoId);

    List<Sale> selectSaleInfo();

    int updateSaleStateInfo(String salesInfoId, Integer state);

    int updateSaleInfo(Sale sale, String salesInfoId);

}
