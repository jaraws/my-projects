package com.jaraws.springbootjwt.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jaraws.springbootjwt.security.JwtAuthenticationEntryPoint;
import com.jaraws.springbootjwt.security.JwtAuthenticationProvider;
import com.jaraws.springbootjwt.security.JwtAuthenticationTokenFilter;
import com.jaraws.springbootjwt.security.JwtSuccessHandler;

/**
 * WebSecurityConfigurerAdapter: To boot strap the configured application security
 * 
 * A custom filter is created for JWT authentication called JWT Authentication Filter.
 * By default spring boot provides LDAP authentication filter.
 * 
 * @author SWARAJ
 *
 */
@EnableGlobalMethodSecurity(prePostEnabled=true) // for method level access controls
@EnableWebSecurity
@Configuration
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    private JwtAuthenticationProvider authenticationProvider;

    @Autowired
    private JwtAuthenticationEntryPoint entryPoint;

    /**
     * Defining the custom authentication manager for authenticating the
     * web requests
     */
	@Bean
    public AuthenticationManager authenticationManager() {
		// authentication provider providing the custom authentication providers
        return new ProviderManager(Collections.singletonList(authenticationProvider));

    }
	
	@Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilter() {
        JwtAuthenticationTokenFilter filter = new JwtAuthenticationTokenFilter();
        /*
         * Setting up authentication manager
         */
        filter.setAuthenticationManager(authenticationManager());
        /*
         * Adding success custom handler to redirect a request in case of
         * of a successful authentication of a request
         */
        filter.setAuthenticationSuccessHandler(new JwtSuccessHandler());
        return filter;
    }
	
	 @Override
	 protected void configure(HttpSecurity http) throws Exception {

	        http.csrf().disable() // disable csrf security
	        		// authorize all request having /rest/ in their request uri, rest all will not be authenticated
	        		// anyRequest(): to authorize all the requests
	                .authorizeRequests().antMatchers("**/rest/**").authenticated()
	                .and()
	                // defining an entry point in case of an exception or failure while authenticating the JWT token
	                .exceptionHandling().authenticationEntryPoint(entryPoint)
	                .and()
	                // Making the session state less that we need not worry about the state of the session
	                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	        /*
	         * Adding authenticationTokenFilter before UsernamePasswordAuthenticationFilter which is provided
	         * by Spring boot by default.
	         */
	        http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	        /*
	         * To add some cache control headers to the http response
	         */
	        http.headers().cacheControl();
    }
}
