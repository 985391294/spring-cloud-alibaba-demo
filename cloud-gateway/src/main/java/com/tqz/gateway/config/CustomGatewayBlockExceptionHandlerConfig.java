package com.tqz.gateway.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.result.view.ViewResolver;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 *
 *
 * @author tianqingzhao
 * @since 2021/3/3 17:03
 */
@Configuration
public class CustomGatewayBlockExceptionHandlerConfig {

    private final List<ViewResolver> viewResolvers;
    private final ServerCodecConfigurer serverCodecConfigurer;


    public CustomGatewayBlockExceptionHandlerConfig(ObjectProvider<List<ViewResolver>> viewResolversProvider,
                                ServerCodecConfigurer serverCodecConfigurer) {
        this.viewResolvers = viewResolversProvider.getIfAvailable(Collections::emptyList);
        this.serverCodecConfigurer = serverCodecConfigurer;
    }

    @Bean
    public CustomGatewayBlockExceptionHandler customGatewayBlockExceptionHandler() {
        return new CustomGatewayBlockExceptionHandler(viewResolvers, serverCodecConfigurer);
    }
}
