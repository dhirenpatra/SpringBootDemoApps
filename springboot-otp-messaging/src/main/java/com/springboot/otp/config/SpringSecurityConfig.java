package com.springboot.otp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.err.println("Called AuthenticationManagerBuilder");
        auth.inMemoryAuthentication()
                .withUser("dhiren")
                .password("November@13")
                .roles("ADMIN")
                .and()
                .withUser("anushka")
                .password("December@21")
                .roles("USER");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    protected void configure(HttpSecurity http) throws Exception {
        System.err.println("Called HttpSecurity");
        http.authorizeRequests()
                .antMatchers( "/courses").hasAnyRole("ADMIN", "USER")
                .antMatchers( HttpMethod.DELETE,"/courses").hasRole("ADMIN")

                .and().formLogin().disable();
    }

}
