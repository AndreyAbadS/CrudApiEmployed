package com.example.DemoCrud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(request -> request
                        .requestMatchers("/api/v1/employed/**").permitAll()

                )
                .csrf(crfs ->
                {
                    try {
                        crfs.and().headers().addHeaderWriter(new StaticHeadersWriter("Expect-CT", "max-age=3600, enforce")
                                ).httpStrictTransportSecurity(strictTransport -> strictTransport.requestMatcher(AnyRequestMatcher.INSTANCE)
                                        .includeSubDomains(true).maxAgeInSeconds(31536000)).contentSecurityPolicy("default-src 'self';img-src data: https:;object-src 'none'; script-src https://stackpath.bootstrapcdn.com/ 'self' 'unsafe-inline';style-src https://stackpath.bootstrapcdn.com/ 'self' 'unsafe-inline'; upgrade-insecure-requests;")
                                .and().frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }).csrf().disable()
                .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();

    }
}
