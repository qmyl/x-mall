package com.xmall.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Value("${security.oauth2.resource.id:spring-boot-application}")
    private String resourceId;

    @Autowired
    private DataSource dataSource;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources){
        resources.resourceId(resourceId);
        resources.tokenStore(tokenStore());
    }

    @Bean
    public TokenStore tokenStore(){
        Assert.state(dataSource != null, "Datasource must be provided");
        return  new JdbcTokenStore(dataSource);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint((request,response,authException)-> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }
}
