/**
 * 
 */
package com.example.openapi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.openapi.filter.CommonFiter;
import com.example.openapi.filter.CommonHeaderFiter;
import com.example.openapi.filter.CustomerProfilesFiter;

/**
 * @author 86211
 *
 */
@Configuration
public class FilterConfiguration {
    
    @Autowired
    CommonFiter commonFiter;
    
    @Autowired
    CommonHeaderFiter commonHeaderFiter;
    
    @Autowired
    CustomerProfilesFiter customerProfilesFiter;

    @Bean
    public FilterRegistrationBean<CommonFiter> commonFiterRegistration() {
        FilterRegistrationBean<CommonFiter> registrationBean = new FilterRegistrationBean<CommonFiter>(commonFiter);
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("commonFiter");
        registrationBean.setOrder(1);
        return registrationBean;
    }
    
    @Bean
    public FilterRegistrationBean<CommonHeaderFiter> commonHeaderFiterRegistration() {
        FilterRegistrationBean<CommonHeaderFiter> registrationBean = new FilterRegistrationBean<CommonHeaderFiter>(commonHeaderFiter);
        registrationBean.addUrlPatterns("/api/v1/customer/*");
        registrationBean.setName("commonHeaderFiter");
        registrationBean.setOrder(2);
        return registrationBean;
    }
    
    @Bean
    public FilterRegistrationBean<CustomerProfilesFiter> customerProfilesFiterRegistration() {
        FilterRegistrationBean<CustomerProfilesFiter> registrationBean = new FilterRegistrationBean<CustomerProfilesFiter>(customerProfilesFiter);
        registrationBean.addUrlPatterns("/api/v1/customer/profiles");
        registrationBean.setName("CustomerProfilesFiter");
        registrationBean.setOrder(3);
        return registrationBean;
    }

}
