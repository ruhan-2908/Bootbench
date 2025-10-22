package com.example.SpringBootL.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http.authorizeHttpRequests(authz ->
                    authz.requestMatchers(HttpMethod.POST,"/api/users").permitAll()
                            .requestMatchers("/api/users/**").authenticated()
                            .anyRequest().permitAll()
        )
                .formLogin(form -> form.permitAll().defaultSuccessUrl("/dashboard"))
                .csrf(csrf->csrf.disable())
        ;
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailService(PasswordEncoder passwordEncoder)
    {
        UserDetails user = User.withUsername("alice")
                .password(passwordEncoder.encode("user123"))
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("zack")
                 .password(passwordEncoder.encode("admin123"))
                 .roles("ADMIN")
                 .build();
        return new InMemoryUserDetailsManager(user,admin);
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
