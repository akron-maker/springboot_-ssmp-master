package com.akron.configuration;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:Akron
 * @Date:created in 21:44 2022/1/22
 */
@Configuration
public class MPConfig {

    @Bean//分页拦截器
    public MybatisPlusInterceptor mybatisPlusInterceptorlus(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();//定义拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());//添加具体拦截器PaginationInnerInterceptor()
        return interceptor;
    }
}
