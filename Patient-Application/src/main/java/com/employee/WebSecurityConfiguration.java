package com.employee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

// Authentication for limited page/object
@Configuration
public class WebSecurityConfiguration {

    @Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
        .cors().and()
        .csrf().disable().authorizeRequests()
        .antMatchers("/patients").hasRole("admin") // Reserve patients only accessible to admins
        .anyRequest().authenticated()
        .and()
        .formLogin();
        return http.build();
	}

    /* 
    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> {
        web.ignoring().antMatchers("/ignore1", "/ignore2");
    };
    */
}