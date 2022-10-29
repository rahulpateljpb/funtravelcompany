package com.driver.funtravel.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// add our users for in memory authentication
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("user").password("test123").roles("EMPLOYEE"))
			.withUser(users.username("manager").password("test123").roles("MANAGER"))
			.withUser(users.username("admin").password("test123").roles("ADMIN"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

//		http.authorizeRequests()
//				.anyRequest().authenticated()
//			.and()
//			.formLogin()
//				.loginPage("/showMyLoginPage")
//				.loginProcessingUrl("/authenticateTheUser")
//				.permitAll()
//			.and()
//			.logout().permitAll();
//		
		http.authorizeRequests()
		.antMatchers("/console/**").permitAll()
		.and()
		.authorizeRequests()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/showMyLoginPage")
		.loginProcessingUrl("/authenticateTheUser")
		.permitAll()
		.and()
		.logout().permitAll();
		
		
		
		
//			.and()
//            .authorizeRequests().anyMatchers("/console/**").permitAll();;
//			
  http.csrf().disable();
  http.headers().frameOptions().disable();
		
	}
	
//	@Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeRequests().antMatchers("/").permitAll().and()
//                .authorizeRequests().antMatchers("/console/**").permitAll();
//        httpSecurity.csrf().disable();
//        httpSecurity.headers().frameOptions().disable();
//    }
		
}
