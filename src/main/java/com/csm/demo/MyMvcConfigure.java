package com.csm.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.*;

import java.util.ResourceBundle;

@Configuration
public class MyMvcConfigure implements WebMvcConfigurer {

    /**
     * preHandle:1->2->3
     * postHandle:3->2->1
     * afterCompletion:3->2->1
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
//        registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**");
//        registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**");
        registry.addInterceptor(new LocaleChangeInterceptor());
    }

//    国际化
//    1.AcceptHeaderLocaleResolver 普遍
//    2.FixedLocaleResolver 固定的 low爆了
//    3.SessionLocaleResolver 存在Session里
//    4.CookieLocaleResolver 存在Cookie里

//    @Bean
//    public ResourceBundleMessageSource messageSource(){
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//        messageSource.setBasename("messages");
//        return messageSource;
//    }

    @Bean
    public LocaleResolver localeResolver(){
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setLocaleAttributeName("lang");
        return localeResolver;
    }
}
