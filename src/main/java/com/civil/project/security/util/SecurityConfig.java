package com.civil.project.security.util;

import com.civil.project.security.filter.JwtRequestFilter;
import com.civil.project.security.service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final MyUserDetailsService myUserDetailsService;
    private final JwtRequestFilter jwtRequestFilter;
    private final String[] paths = {"/deces/**","/marginales-deces-ar/**"
    ,"/marginales-deces-fr/**", "/registre-actes-deces/**","/juge-deces/**",
    "/marginales-juges-deces-ar/**", "/marginales-juges-deces-fr/**","/registre-juges-deces/**",
    "/juges-naissance/**", "/marginales-juges-naissances-ar/**","/marginales-juges-naissances-fr/**",
    "/registres-juges-naissance/**","/acte/**","/marginales-fr/**","/marginales-ar/**",
    "/registre-naissance/**",
    };

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().and()
                .authorizeRequests()
                .antMatchers("/auth/login").permitAll()
                .antMatchers("/auth/verify").authenticated()
                .antMatchers(HttpMethod.PUT,paths).hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,paths).hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().
                exceptionHandling().authenticationEntryPoint(authenticationEntryPoint())
                .accessDeniedHandler(accessDeniedHandler());

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedMethods(Arrays.asList("HEAD",
                "GET", "POST", "PUT", "DELETE", "PATCH"));
        configuration.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(
                Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",configuration);
        return  source;

    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return (req, res, e) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                "Vous n'êtes pas autorisé à effectuer cette opération");
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return (req, res, e) -> res.sendError(HttpServletResponse.SC_FORBIDDEN,
                "Vous n'êtes pas autorisé à effectuer cette opération");
    }



}
