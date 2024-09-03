package com.example.demo.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
    private AuthenticationProvider authProvider;
	@Autowired
    private JwtAuthentication jwtAuth;
    
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf
                .disable())
                .authorizeHttpRequests(req->req.requestMatchers("/login").permitAll().requestMatchers("/**").authenticated())
                .sessionManagement(management -> management
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuth, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
	
//	 @Bean
//	 CorsConfigurationSource corsConfigurationSource() {
//	        CorsConfiguration configuration = new CorsConfiguration();
//
//	        configuration.setAllowedOrigins(List.of("http://localhost:8080"));
//	        configuration.setAllowedMethods(List.of("GET","POST"));
//	        configuration.setAllowedHeaders(List.of("Authorization","Content-Type"));
//
//	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//
//	        source.registerCorsConfiguration("/**",configuration);
//
//	        return source;
//	}
}
