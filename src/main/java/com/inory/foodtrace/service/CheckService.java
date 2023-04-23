package com.inory.foodtrace.service;

import com.inory.foodtrace.entity.Check;

import java.util.List;

/**
 * @author inory
 * @create 2021-07-21 18:43
 */
public interface CheckService {

    List<Check> selectCheck();

    int insertCheck(Check check);

    int updateCheck(String id, Integer state);

    int selectCheck(String id);

}
