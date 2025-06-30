package com.groupseven.gateway;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.stream.Collectors;

@SpringBootApplication
@EnableFeignClients
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	@ConditionalOnMissingBean
	// 如果没有找到HttpMessageConverters类型的Bean，则创建一个新的HttpMessageConverters类型的Bean
	public HttpMessageConverters messageConverters(ObjectProvider<HttpMessageConverter<?>> converters) {
		// 使用ObjectProvider获取所有的HttpMessageConverter类型的Bean，并按照顺序收集到一个List中
		return new HttpMessageConverters(converters.orderedStream().collect(Collectors.toList()));
	}
}
