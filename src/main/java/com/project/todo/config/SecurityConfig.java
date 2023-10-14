package com.project.todo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/todos/**")
                .permitAll()
                .antMatchers("/h2-console").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

//    private static class CustomFrameOptionsFilter extends OncePerRequestFilter {
//        @Override
//        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//                throws ServletException, IOException {
//            if (request.getRequestURI().startsWith("/h2-console")) {
//                response.setHeader("X-Frame-Options", "SAMEORIGIN");
//            }
//            filterChain.doFilter(request, response);
//        }
//    }
}
