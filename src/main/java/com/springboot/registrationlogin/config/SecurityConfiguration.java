package com.springboot.registrationlogin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.springboot.registrationlogin.service.UserService;

@Configuration
@EnableWebSecurity // integrates Spring Security with Spring MVC
public class SecurityConfiguration {
	
	@Autowired
	private UserService userService;
	    
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		 DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		 auth.setUserDetailsService(userService);
	     auth.setPasswordEncoder(new BCryptPasswordEncoder());
	     return auth;
	}
	    
	@Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests.requestMatchers(
				"/registration**",
				"/js/**",
				"/css/**",
				"/img/**").permitAll()
		.anyRequest()
		.authenticated())
		.formLogin((form) -> form
		.loginPage("/login")
		.permitAll())
		.logout((logout) -> logout
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout")
		.permitAll());
		
		return http.build();
	}
    
}
