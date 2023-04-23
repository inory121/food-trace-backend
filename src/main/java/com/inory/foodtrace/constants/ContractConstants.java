package com.inory.foodtrace.constants;

public class ContractConstants {

    public static String FoodTraceAbi;

    public static String FoodTraceBinary;


    static {
        try {
            FoodTraceAbi = org.apache.commons.io.IOUtils.toString(Thread.currentThread().getContextClassLoader().getResource("abi/FoodTrace.abi"));
            FoodTraceBinary = org.apache.commons.io.IOUtils.toString(Thread.currentThread().getContextClassLoader().getResource("bin/ecc/FoodTrace.bin"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
