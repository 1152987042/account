package com.kkb.marketing.introduce.api.config;

import feign.Request;
import feign.Retryer;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


@Configuration
@Slf4j
public class FeignConfig {


    /**
     * feign的超时时间
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(Request.Options.class)
    public Request.Options feignRequestOptions() {
        Request.Options options = new Request.Options(1000, 2000);
        return options;
    }


    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default();
    }

    /**
     * feign连接池
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(HttpClient.class)
    public HttpClient httpClient() {
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
        connManager.setMaxTotal(100);
        connManager.setDefaultMaxPerRoute(100);
        List<Header> defaultHeaders = new ArrayList<Header>();
        defaultHeaders.add(new BasicHeader("Accept-Encoding", "gzip,deflate"));
        defaultHeaders.add(new BasicHeader("Accept-Language", "zh-CN"));
        defaultHeaders.add(new BasicHeader("Connection", "Keep-Alive"));
        HttpClient httpClient =
                HttpClientBuilder.create().setConnectionManager(connManager)
                        .setDefaultHeaders(defaultHeaders)
                        .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
                        .setRetryHandler((exception, executionCount, context) -> {
                            if (executionCount <= 3) {
                                log.info("重试次数:{}",executionCount);
                                return true;
                            }
                            return false;
                        })
                        .build();
        return httpClient;
    }
}
