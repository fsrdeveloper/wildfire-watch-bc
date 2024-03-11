package ca.bc.gov.wildfirewatch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll() // Allow access to all URLs
                .and()
                .csrf().disable() // Disable CSRF protection for simplicity
                .headers().frameOptions().disable(); // Disable X-Frame-Options header for H2 Console (if used)
    }
}
