/**
 * 
 */
package com.blog;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author govind yadav
 *
 */
//@Configuration
//@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{



	  /*@Override
	   protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	        auth.inMemoryAuthentication()
	                .withUser("user").password("{noop}password").roles("USER")
	                .and()
	                .withUser("admin").password("{noop}password").roles("USER", "ADMIN");

	    }

	  
	  
	    // Secure the endpoins with HTTP Basic authentication
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {

	        http
	                //HTTP Basic authentication
	                .httpBasic()
	                .and()
	                .authorizeRequests()
	                .antMatchers(HttpMethod.GET, "/**").hasRole("USER")
	                .antMatchers(HttpMethod.POST, "/subject").hasRole("ADMIN")
	                .and()
	                .csrf().disable()
	                .formLogin().disable();
	    }
*/
}
