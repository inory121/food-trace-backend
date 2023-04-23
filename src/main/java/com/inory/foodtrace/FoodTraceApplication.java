package com.inory.foodtrace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(excludeFilters = @ComponentScan.Filter
//        (type = FilterType.ASSIGNABLE_TYPE, classes = {BcosConfig.class, ContractConfig.class, SdkBeanConfig.class, SystemConfig.class
//        }))

public class FoodTraceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodTraceApplication.class, args);
    }

}
