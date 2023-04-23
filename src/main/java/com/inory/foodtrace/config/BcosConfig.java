package com.inory.foodtrace.config;

import lombok.Data;
import org.fisco.bcos.sdk.config.model.AmopTopic;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Data
@Configuration
@ConfigurationProperties
public class BcosConfig {
    public Map<String, List<String>> network;
    public List<AmopTopic> amop;
    public Map<String, Object> account;
    public Map<String, Object> threadPool;
    private Map<String, Object> cryptoMaterial;
}
