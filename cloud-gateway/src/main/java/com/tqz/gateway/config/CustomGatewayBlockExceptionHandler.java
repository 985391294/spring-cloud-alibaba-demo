package com.tqz.gateway.config;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.util.function.Supplier;
import com.alibaba.fastjson.JSON;
import com.tqz.common.base.ResultData;
import com.tqz.common.base.ReturnCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.codec.HttpMessageWriter;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.result.view.ViewResolver;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * <p>
 * 网关自定义限流返回
 *
 * @author tianqingzhao
 * @since 2021/3/3 17:01
 */
@Component
public class CustomGatewayBlockExceptionHandler implements WebExceptionHandler {

    @Autowired
    private InetUtils inetUtils;

    private List<ViewResolver> viewResolvers;
    private List<HttpMessageWriter<?>> messageWriters;
    private final Supplier<ServerResponse.Context> contextSupplier = () -> {
        return new ServerResponse.Context() {
            @Override
            public List<HttpMessageWriter<?>> messageWriters() {
                return CustomGatewayBlockExceptionHandler.this.messageWriters;
            }

            @Override
            public List<ViewResolver> viewResolvers() {
                return CustomGatewayBlockExceptionHandler.this.viewResolvers;
            }
        };
    };

    public CustomGatewayBlockExceptionHandler(List<ViewResolver> viewResolvers, ServerCodecConfigurer serverCodecConfigurer) {
        this.viewResolvers = viewResolvers;
        this.messageWriters = serverCodecConfigurer.getWriters();
    }

    /**
     * 重写限流响应，改造成JSON格式的响应数据
     * @author jianzhang11
     * @date 2020/1/20 15:03
     */
    private Mono<Void> writeResponse(ServerResponse response, ServerWebExchange exchange) {
        ServerHttpResponse serverHttpResponse = exchange.getResponse();
        serverHttpResponse.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        ResultData<Object> resultData = ResultData.fail(ReturnCode.RC201.getCode(), ReturnCode.RC201.getMessage());
        String resultString = JSON.toJSONString(resultData);
        DataBuffer buffer = serverHttpResponse.bufferFactory().wrap(resultString.getBytes());
        return serverHttpResponse.writeWith(Mono.just(buffer));
    }

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        if (exchange.getResponse().isCommitted()) {
            return Mono.error(ex);
        } else {
            return !BlockException.isBlockException(ex) ? Mono.error(ex) : this.handleBlockedRequest(exchange, ex).flatMap((response) -> this.writeResponse(response, exchange));
        }
    }

    private Mono<ServerResponse> handleBlockedRequest(ServerWebExchange exchange, Throwable throwable) {
        return GatewayCallbackManager.getBlockHandler().handleRequest(exchange, throwable);
    }

//解决sentinel控制台不能显示API管理问题
//    @PostConstruct
//    public void doInit() {
//        System.setProperty(TransportConfig.HEARTBEAT_CLIENT_IP, inetUtils.findFirstNonLoopbackAddress().getHostAddress());
////        SentinelConfig.setConfig(TransportConfig.HEARTBEAT_CLIENT_IP, inetUtils.findFirstNonLoopbackAddress().getHostAddress());
//    }

}
