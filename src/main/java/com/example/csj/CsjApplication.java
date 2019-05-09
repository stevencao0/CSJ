package com.example.csj;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Configuration 
public class CsjApplication extends WebSecurityConfigurerAdapter  {

	public static void main(String[] args) {
		SpringApplication.run(CsjApplication.class, args);
	}
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
            .and().oauth2Client()
            .and().oauth2Login()
            .and().csrf().ignoringAntMatchers("/home/**")
            .and().csrf().ignoringAntMatchers("/group/**");
    }
}
