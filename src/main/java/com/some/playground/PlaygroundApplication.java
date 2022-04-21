package com.some.playground;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class PlaygroundApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(PlaygroundApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}
