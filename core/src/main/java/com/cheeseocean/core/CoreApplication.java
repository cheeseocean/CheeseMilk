package com.cheeseocean.core;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.cheeseocean.common.util.CheeseOceanBanner;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.cheeseocean.core.**")
public class CoreApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .banner(new CheeseOceanBanner())
                .sources(CoreApplication.class)
                .run(args);
    }
}
