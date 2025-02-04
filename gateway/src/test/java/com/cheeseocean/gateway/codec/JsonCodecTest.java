package com.cheeseocean.gateway.codec;

import org.junit.jupiter.api.Test;
import org.springframework.core.ResolvableType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class JsonCodecTest {

    @Test
    public void codecTest() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("helloxc"));
        Jackson2JsonDecoder decoder = new Jackson2JsonDecoder();
        decoder.decode(DataBufferUtils.read(new ClassPathResource("test.json"), new DefaultDataBufferFactory(), 4096), ResolvableType.forType(LoginEntity.class), null, null)
                .doOnNext(body -> {
                    System.out.println(((LoginEntity) body).getIdentifier());
                }).subscribe();
    }
}
