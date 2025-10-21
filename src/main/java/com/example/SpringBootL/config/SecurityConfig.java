package com.example.SpringBootL.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http.authorizeHttpRequests(authz ->
                    authz.requestMatchers("/api/users/**").authenticated()
                            .requestMatchers("/").permitAll()
        )
                .formLogin(form -> form.permitAll())
        ;
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailService()
    {
        UserDetails user = User.withUsername("alice")
                .password("user123")
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("zack")
                 .password("admin123")
                 .roles("ADMIN")
                 .build();
        return new InMemoryUserDetailsManager(user,admin);
    }

}
