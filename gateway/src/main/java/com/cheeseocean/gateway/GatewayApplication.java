package com.cheeseocean.gateway;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.session.data.redis.config.annotation.web.server.EnableRedisWebSession;

import com.cheeseocean.common.entity.User;
import com.cheeseocean.common.util.CheeseOceanBanner;


@SpringBootApplication
@EnableDiscoveryClient
@EnableRedisWebSession
@EnableR2dbcRepositories(basePackages = "com.cheeseocean.gateway.repository")
@EntityScan(basePackageClasses = {User.class})
public class GatewayApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .banner(new CheeseOceanBanner())
                .sources(GatewayApplication.class)
                .run(args);
    }
}
