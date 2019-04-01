package com.xmall.auth.config;

import com.xmall.auth.dto.UserServiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;

//加上@EnableWebSecurity注解，开启WebSecurity功能
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure( HttpSecurity http ) throws Exception
    {

        http.requestMatchers().anyRequest()
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/**").permitAll();

    }

    @Autowired
    UserServiceDetail userServiceDetail;

    @Override
    protected void configure( AuthenticationManagerBuilder auth ) throws Exception{
        auth.userDetailsService( userServiceDetail ).passwordEncoder(passwordEncoder());
    }

//    @Override
//    protected  void configure( AuthenticationManagerBuilder auth ) throws Exception{
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String finalPassword = "{bcrypt}" + bCryptPasswordEncoder.encode("123456");
//        auth.inMemoryAuthentication()
//                .withUser("user_1").password(finalPassword).roles("USER");
//    }


}
