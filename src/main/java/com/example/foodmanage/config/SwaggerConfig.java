package com.example.foodmanage.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI springDocOpenAPI() {
        return new OpenAPI().info(new Info().title("外卖管理系统 - 在线API接口文档")
                .description("大部分以JSON数据格式返回！！！")
                .version("1.0"));
    }
}
