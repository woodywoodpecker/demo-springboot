package com.py4j.demospringboot.application.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @Author Warren
 * @CreateTime 17.May.2018
 * @Version V1.0
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler handler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/webjars/**","/login","/css/**","/image/*","/", "/home", "/about").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("USER")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .permitAll()
                .and()
            .exceptionHandling().accessDeniedHandler(handler);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        /**
         * java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
         * 这个地方有个坑，spring-security-core:5的默认PasswordEncoder 是DelegatingPasswordEncoder，
         * 但是在尝试直接将账号密码存放在内存的时候，会显示DelegatingPasswordEncoder找不到。如果我们加了
         * {noop}，就会使用NoOpPasswordEncoder校验密码，不过为了安全，后面再来改进这个地方的代码
         */
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}12345").roles("USER");
    }
}
