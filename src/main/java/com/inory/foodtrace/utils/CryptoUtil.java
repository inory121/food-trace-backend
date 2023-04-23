package com.inory.foodtrace.utils;

import org.fisco.bcos.sdk.crypto.CryptoSuite;
import org.fisco.bcos.sdk.model.CryptoType;

/**
 * @author inory
 * @create 2021-08-05 1:05
 */
public class CryptoUtil {

    public static String crypto(String data) {
        return new CryptoSuite(CryptoType.ECDSA_TYPE).hash(data);
    }
}
