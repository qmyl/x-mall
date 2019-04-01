package com.xmall.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;


@EnableEurekaClient
@SpringBootApplication
@EnableResourceServer
public class Oauth2ServerApplication {

//    @GetMapping("/user")
//    public @ResponseBody Principal user(Principal user){
//        return user;
//    }
//
//    @GetMapping("/login")
//    public String login(Model model , HttpServletRequest request, @RequestParam(value="error" , required = false ) String error ){
//        CsrfToken token = (CsrfToken) request.getAttribute( CsrfToken.class.getName() );
//        if( token != null ){
//            model.addAttribute("error","用户或密码错误");
//        }
//        return "login";
//    }

    public static void main(String[] args){
        SpringApplication.run(Oauth2ServerApplication.class ,args);
    }
}
