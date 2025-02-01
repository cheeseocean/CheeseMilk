package com.cheeseocean.gateway;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.session.data.redis.config.annotation.web.server.EnableRedisWebSession;

import com.cheeseocean.common.util.CheeseOceanBanner;


@SpringBootApplication
@EnableDiscoveryClient
@EnableRedisWebSession
public class GatewayApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .banner(new CheeseOceanBanner())
                .sources(GatewayApplication.class)
                .run(args);
    }
}
