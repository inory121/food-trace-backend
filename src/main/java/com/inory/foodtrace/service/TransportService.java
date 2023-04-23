package com.inory.foodtrace.service;

import com.inory.foodtrace.entity.Transport;

import java.util.List;

/**
 * @author inory
 * @create 2021-07-21 18:43
 */
public interface TransportService {

    void insertTransportInfo(Transport transport);

    Transport selectTransportInfo(String transportID);

    List<Transport> selectTransportInfo();

    int updateTransportInfo(Transport transport, String transportID);

    int updateTransportStateInfo(String transportID, Integer state);

}
