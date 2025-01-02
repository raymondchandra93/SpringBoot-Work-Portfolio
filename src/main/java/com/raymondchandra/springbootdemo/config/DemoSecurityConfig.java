package com.raymondchandra.springbootdemo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
	
	// Using JDBC users but Custom tables
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
		
		manager
			.setUsersByUsernameQuery("SELECT user_id, pw, active FROM members WHERE user_id=?");
		
		manager
			.setAuthoritiesByUsernameQuery("SELECT user_id, role FROM roles WHERE user_id=?");
		
		return manager;
	}
	
	// Using JDBC users
//	@Bean
//	public UserDetailsManager userDetailsManager(DataSource dataSource) {
//		return new JdbcUserDetailsManager(dataSource);
//	}

	// Using hardcoded user
//	@Bean
//	public InMemoryUserDetailsManager userDetailsManager() {
//		UserDetails john = User.builder()
//			.username("john")
//			.password("{noop}test123")
//			.roles("EMPLOYEE")
//			.build();
//
//		UserDetails mary = User.builder()
//				.username("mary")
//				.password("{noop}test123")
//				.roles("EMPLOYEE", "MANAGER")
//				.build();
//		
//		UserDetails susan = User.builder()
//				.username("susan")
//				.password("{noop}test123")
//				.roles("EMPLOYEE", "MANAGER", "ADMIN")
//				.build();
//		
//		return new InMemoryUserDetailsManager(john, mary, susan);
//	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer ->
			configurer
				.requestMatchers(HttpMethod.GET, "/api/v1/employees").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.GET, "/api/v1/employees/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "/api/v1/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "/api/v1/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/api/v1/employees").hasRole("ADMIN")
		);
		
		// user HTTP Basic Authentication
		http.httpBasic(Customizer.withDefaults());

		// disable CSRF
		http.csrf(csrf -> csrf.disable());
		
		return http.build();
	}
}
