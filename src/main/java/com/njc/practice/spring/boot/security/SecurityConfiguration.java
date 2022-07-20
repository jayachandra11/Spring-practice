package com.njc.practice.spring.boot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.njc.practice.spring.boot.filters.JwtRequestFilter;



@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/njc/students").hasRole("ADMIN")
//								.antMatchers("/njc/student/prac").hasAnyRole("USER", "ADMIN")
//								.antMatchers("/").permitAll().and().formLogin();
//	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/njc/admin").hasRole("ADMIN")
//			.antMatchers("/njc/user").hasAnyRole("ADMIN", "USER")
//			.antMatchers("/all").permitAll()
//			.and().formLogin();
//	}
   @Override
    protected void configure(HttpSecurity http) throws Exception {
	   //we are making session management stateless using jwt
    		http.csrf().disable()
    				   .authorizeHttpRequests().antMatchers("/njc/authenticate").permitAll()
    				   .antMatchers("/njc/admin").hasRole("ADMIN")
    				   .antMatchers("/njc/user").hasAnyRole("ADMIN", "USER")
    				   .anyRequest().authenticated()
    				   .and().sessionManagement()
    				   .sessionCreationPolicy(SessionCreationPolicy.STATELESS); 
    		// we are stating that the this jwt request filter is called before authentication is called
    		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class); 
    }
    

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("user1").password("user1").roles("USER").and().withUser("user2")
//				.password("user2").roles("ADMIN");
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/njc/students").hasRole("ADMIN")
//								.antMatchers("/njc/student/prac").hasAnyRole("USER", "ADMIN")
//								.antMatchers("/").permitAll().and().formLogin();
//	}
//
 
   
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
    @Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
}
