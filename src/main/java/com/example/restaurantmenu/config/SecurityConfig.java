package com.example.restaurantmenu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authorizeRequests) -> authorizeRequests
                .requestMatchers("/", "/menu", "/contact").permitAll()
                .requestMatchers("/admin/**").authenticated()
                .anyRequest().permitAll()
                )

                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login")
                                .permitAll()
                                .defaultSuccessUrl("/admin/items", true)
                )
                .logout(logout ->
                        logout
                                .permitAll()
                                .logoutSuccessUrl("/login?logout")
                )
                .csrf(csrf -> csrf.disable()); // Отключить CSRF для простоты, но включить в продакшене

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin_password")
                .roles("ADMIN")
                .build());
        return manager;
    }
}
