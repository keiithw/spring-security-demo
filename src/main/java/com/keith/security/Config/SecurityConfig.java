package com.keith.security.Config;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Bean
//    public UserDetailsService userDetailsService(){
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("ee").password("233").roles("USER").build());
//        return manager;
//    }

    /**
     * 自定义拦截页面和访问权限
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/hi").hasRole("USER")
                .antMatchers("/index").permitAll()
                .and().formLogin()
                .and().httpBasic();
    }

    /**
     * 创建用户并设置encoder
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("keith")
                .password(new CustomEncoder().encode("233"))
                .roles("USER")
                .and()
                .passwordEncoder(new CustomEncoder());
    }
}

