package com.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.blog.service.CustomUserDetailsService;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService());
//        authProvider.setPasswordEncoder(passwordEncoder());
//
//        return authProvider;
//    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/db/**", "/login", "/admin/login").permitAll()
                .antMatchers( "/vendor/**", "/static/**", "/css/**", "/js/**", "/images/**", "/css/lib/**", "/fonts/**", "/scss/**", "/img/**").permitAll()
                .antMatchers("/*").permitAll()
                .antMatchers("/admin/*").authenticated()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/admin/login").permitAll()
                .defaultSuccessUrl("/admin/admin", true)
                .failureUrl("/admin/login?error=true").permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/admin/login?logout").permitAll()
                .and()
                .headers().frameOptions().disable()
                .and()
                .csrf().disable();
    }

//	@Bean
//	@Override
//	public UserDetailsService userDetailsServicee() {
//		UserDetails user =
//			 User.withDefaultPasswordEncoder()
//				.username("asd")
//				.password("asd")
//				.roles("")
//				.build();
//
//		return new InMemoryUserDetailsManager(user);
//	}
}
