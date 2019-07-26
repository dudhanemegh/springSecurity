package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Override
	public void configure(final HttpSecurity http) throws Exception {
		http.antMatcher("/**").authorizeRequests()
		.antMatchers(HttpMethod.POST, "/api/employee/{employeeId}").permitAll()
		.antMatchers(HttpMethod.GET, "/api/employee/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT, "/api/employee/{employeeId}").permitAll()
		.antMatchers(HttpMethod.DELETE, "/api//employee/{employeeId}").permitAll()
		.anyRequest().authenticated()
		.and()
		.oauth2Login();
	}

}
