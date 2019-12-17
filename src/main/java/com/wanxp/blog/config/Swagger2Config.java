package com.wanxp.blog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    /**
     * 为了在生产环境中不启用swagger，此处需要读取配置文件中的配置
     */
    @Value("${swagger2.enable}")
    private Boolean enable;

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enable)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    /**
     * 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
     */
    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "博客",
                "个人博客",
                "mvp",
                "http://www.baidu.com",
                new Contact("万旭平","http://www.baidu.com","977741432@qq.com"),
                "私有权限",
                "私有权限",
                Collections.emptyList()
        );
    }
}
