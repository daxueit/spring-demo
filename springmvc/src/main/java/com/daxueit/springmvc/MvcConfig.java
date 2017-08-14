package com.daxueit.springmvc;

import com.daxueit.springmvc.beans.prepost.InitMethodBean1;
import com.daxueit.springmvc.beans.prepost.InitMethodBean2;
import com.daxueit.springmvc.beans.profile.ProfileBean;
import com.daxueit.springmvc.beans.spel.SpELBean;
import com.daxueit.springmvc.event.DemoPublisher;
import com.daxueit.springmvc.service.spel.DemoService;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by whhuang on 2017/8/12.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.daxueit.springmvc")
@PropertySource("classpath:com/daxueit/springmvc/beans/spel/spel.properties")
@EnableScheduling
public class MvcConfig extends WebMvcConfigurerAdapter {
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    @Bean
    @Profile("prod")
    public ProfileBean prodProfileBean(){
        return new ProfileBean("prod bean!");
    }

    @Bean
    @Profile("dev")
    public ProfileBean devProfileBean(){
        return new ProfileBean("dev bean!");
    }

    @Bean(initMethod="init",destroyMethod="destroy")
    public InitMethodBean2 initMethodBean2(){
        return new InitMethodBean2();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigure() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("/index");
        registry.addViewController("/default").setViewName("/index");
        super.addViewControllers(registry);
    }
}
