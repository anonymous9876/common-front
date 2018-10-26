package name.anonymous.common.front.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import name.anonymous.common.front.configuration.jquery.filter.JQueryArrayParameterFilter;

@Configuration
public class JqueryConfiguration {
    @Bean
    public JQueryArrayParameterFilter jQueryArrayParameterFilter() {
        return new JQueryArrayParameterFilter();
    }

    @Bean
    public FilterRegistrationBean<JQueryArrayParameterFilter> filterRegistrationBean(JQueryArrayParameterFilter filter) {
        FilterRegistrationBean<JQueryArrayParameterFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(filter);
        filterRegistrationBean.addUrlPatterns("*");
        return filterRegistrationBean;
    }
}