package com.github.knastasov.securingweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Profile("!https")
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers(HttpMethod.GET, "/index*", "/static/**", "/*.js", "/*.json", "/*.ico").permitAll()
				.anyRequest().authenticated().and().formLogin().loginPage("/index.html")
				.loginProcessingUrl("/perform_login").defaultSuccessUrl("/homepage.html", true)
				.failureUrl("/index.html?error=true");
	}
}