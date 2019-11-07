package com.wanxp.blog.config;

import com.wanxp.blog.component.ThymeleafComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThymeleafConfig {
    @Bean("components")
    public ThymeleafComponent components() {
        return new ThymeleafComponent();
    }
}
