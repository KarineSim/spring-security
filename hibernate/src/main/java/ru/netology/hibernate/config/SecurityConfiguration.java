package ru.netology.hibernate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Petr")
                .password("{noop}adm")
                .authorities("age", "name")
                .and()
                .withUser("Semen")
                .password("{noop}pas1")
                .authorities("age")
                .and()
                .withUser("Alexey")
                .password("{noop}pas2")
                .authorities("name");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeRequests().antMatchers("/persons/by-city").permitAll()
                .and()
                .authorizeRequests().antMatchers("/persons/by-age-desc").hasAuthority("age")
                .and()
                .authorizeRequests().antMatchers("/persons/by-name-surname").hasAuthority("name")
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }
}
