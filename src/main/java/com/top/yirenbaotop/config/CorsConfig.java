package com.top.yirenbaotop.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 解决跨域配置类
 */
@Configuration
public class CorsConfig {
    //定义访问语言 ip
    public final  String [] origins={"127.0.0.1","localhost","www.baidu.com","google.com"};


    //跨域过滤器
    @Bean
    public CorsFilter corsFilter(){
        //创建跨域配置对象
        CorsConfiguration corsConfiguration=new CorsConfiguration();
        //配置允许访问的协议
       addAllowedOrigin(corsConfiguration);
       //不限制访问请求头部信息
       corsConfiguration.addAllowedHeader("*");
        //不限制请求方式
       corsConfiguration.addAllowedMethod("*");
       //允许session共享
       corsConfiguration.setAllowCredentials(true);
        //创建基于url的跨域配置对象
        UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
        //  /**代表可以多层请求
        source.registerCorsConfiguration("/**",corsConfiguration);

        return new CorsFilter(source);
    }

    private void addAllowedOrigin(CorsConfiguration corsConfiguration) {
        for(String origin:origins){
            corsConfiguration.addAllowedOrigin("http://"+origin);
            corsConfiguration.addAllowedOrigin("https://"+origin);
        }
    }

}
