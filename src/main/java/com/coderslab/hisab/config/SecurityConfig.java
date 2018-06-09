package com.coderslab.hisab.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @author Zubayer Ahamed
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired private DataSource dataSource;
	@Autowired private LoggingAccessDeniedHandler accessDeniedHandler;
	@Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers(
					"/js/**",
					"/css/**",
					"/img/**",
					"/assets/**",
					"/fonts/**",
					"/upload/**",
					"/webjars/**",
					"/users/**",
					"/register").permitAll()
				.anyRequest().authenticated()
			.and()
				.formLogin()
				.loginPage("/login")
				.failureUrl("/login?error")
				.usernameParameter("username").passwordParameter("password")
				.permitAll()
			.and()
				.logout()
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?logout")
				.permitAll()
			.and()
				.exceptionHandling()
				.accessDeniedHandler(accessDeniedHandler)
			.and()
				.csrf()
				.disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//			.withUser("user").password("password").roles("USER")
//			.and()
//			.withUser("admin").password("admin").roles("ADMIN");
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("select username, password, enabled from user where username = ?")
			.authoritiesByUsernameQuery("select username, authority from authorities where username = ?")
			.passwordEncoder(bCryptPasswordEncoder);
	}

}
