package com.springsecurity.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    /**
     * Configura a cadeia de filtros de segurança HTTP para a aplicação.
     *
     * <p>Este método desabilita a proteção contra CSRF, permite todas as requisições
     * POST para endpoints que começam com "/users/**" sem autenticação, e exige
     * autenticação para todas as outras requisições.</p>
     *
     * @param http a instância {@link HttpSecurity} usada para configurar a segurança HTTP
     * @return a instância {@link SecurityFilterChain} configurada
     * @throws Exception se ocorrer um erro durante a configuração da segurança HTTP
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((request) -> request
                        .requestMatchers(HttpMethod.POST, "/users/**").permitAll()
                        .anyRequest()
                        .authenticated());

        return http.build();
    }


}
