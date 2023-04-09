package com.ems.emploee.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
@Configuration
@EnableWebSecurity
public class securityConfiguration extends WebSecurityConfiguration {
//    @Override
//    public void configure(HttpSecurity httpSecurity) throws Exception{
//        httpSecurity.csrf().disable();
//
//    }
}
