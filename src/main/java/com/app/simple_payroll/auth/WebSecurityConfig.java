package com.app.simple_payroll.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
 
    @Autowired
    private MySavedRequestAwareAuthenticationSuccessHandler
      authenticationSuccessHandler;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().exceptionHandling()
				.authenticationEntryPoint(restAuthenticationEntryPoint).and()
				.authorizeRequests()/*.antMatchers("/greet").permitAll()*/
				.anyRequest().authenticated().and().httpBasic()
				.and()
				.formLogin()/*.successHandler(authenticationSuccessHandler)*/
				.successHandler(authenticationSuccessHandler)
				//.loginProcessingUrl("/login")
				.usernameParameter("username")
                .passwordParameter("password")
				//.defaultSuccessUrl("/greet", true)
			    .permitAll()
				.failureHandler(new SimpleUrlAuthenticationFailureHandler())
				.and().logout();
    }

/*    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }*/
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
  
        auth.inMemoryAuthentication()
          .withUser("temporary").password("temporary").roles("ADMIN")
          .and()
          .withUser("user").password("userPass").roles("USER");
    }
}