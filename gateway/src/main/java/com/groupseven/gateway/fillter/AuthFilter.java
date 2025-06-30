package com.groupseven.gateway.fillter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupseven.common.Result;
import com.groupseven.gateway.UserService;
import com.groupseven.pojo.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

@Slf4j
@Component
public class AuthFilter implements GlobalFilter, Ordered {
    @Autowired
    private UserService userService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.debug("AuthFilter filter");
        //获取访问路径，如果允许匿名访问，直接放行
        String path = exchange.getRequest().getPath().toString();
        log.debug("Path: {}", path);
        if (path.equals("/user/reg") || path.startsWith("/base/") || path.equals("/user/login")) {
            return chain.filter(exchange);
        }
        //获取请求头的令牌
        String token = exchange.getRequest().getHeaders().getFirst("token");
        log.debug("Token: {}", token);
        //如果没有，直接返回给提示
        if (token == null || token.trim().isEmpty()) {
            return getVoidMono(exchange);
        }
        //如果有，将令牌发送到用户服务的校验接口或者解析接口
        Callable<Result<UserVo>> callable = new Callable<>() {
            @Override
            public Result<UserVo> call() throws Exception {
                return userService.parseJWT(token);
            }
        };
        FutureTask<Result<UserVo>> futureTask = new FutureTask<>(callable);

        new Thread(futureTask).start();
        Result<UserVo> result = null;
        try {
            result = futureTask.get();  // 等待结果
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result.getCode() == 200) {
            //从结果中获取用户信息，并且放入后续请求头
            int id = result.getData().getId();
            ServerHttpRequest r = exchange.getRequest().mutate().header("id", String.valueOf(id)).build();
            ServerWebExchange mutableExchange = exchange.mutate().request(r).build();
            return chain.filter(mutableExchange);
        } else {
            //如果校验通过，直接放行，否则，返回提示信息
            return getVoidMono(exchange);
        }
    }
    private Mono<Void> getVoidMono(ServerWebExchange exchange) {
        ServerHttpResponse response = exchange.getResponse();
        Result<Void> responseResult = Result.error(401, "forbid");
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] datas = new byte[0];
        try {
            datas = objectMapper.writeValueAsString(responseResult).getBytes(StandardCharsets.UTF_8);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        DataBuffer buffer = response.bufferFactory().wrap(datas);
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        return response.writeWith(Mono.just(buffer));
   }

    @Override
    public int getOrder() {
        return 0;
    }
}
