package com.idanchuang.shop.user.config;

import com.idanchuang.shop.user.filter.MyFilter;
import com.idanchuang.shop.user.filter.MyFilter2;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.Collections;

@Configuration
public class MyFilterConfig {
    private final
    MyFilter myFilter;

    private final
    MyFilter2 myFilter2;

    public MyFilterConfig(MyFilter myFilter, MyFilter2 myFilter2) {
        this.myFilter = myFilter;
        this.myFilter2 = myFilter2;
    }

    @Bean
    public FilterRegistrationBean<MyFilter> thirdFilter(){
        FilterRegistrationBean<MyFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(myFilter);
        filterRegistrationBean.setUrlPatterns(new ArrayList<>(Collections.singletonList("/api/*")));

        return filterRegistrationBean;
    }


    @Bean
    public FilterRegistrationBean<MyFilter2> setUpMyFilter2() {
        FilterRegistrationBean<MyFilter2> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.setFilter(myFilter2);
        filterRegistrationBean.setUrlPatterns(new ArrayList<>(Collections.singletonList("/api/*")));
        return filterRegistrationBean;
    }
}
