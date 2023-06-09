package com.inory.foodtrace.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(
        prefix = "contract"
)
public class ContractConfig {
    private String foodTraceAddress;
}
