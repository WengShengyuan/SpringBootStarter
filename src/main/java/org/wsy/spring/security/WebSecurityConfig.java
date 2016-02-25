package org.wsy.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.wsy.core.generic.staticparams.StaticParams;
import org.wsy.spring.security.userdetails.MyUserDetailsService;

@Configurable
@EnableWebSecurity
@ComponentScan(basePackageClasses = MyUserDetailsService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		
		.antMatchers(StaticParams.PATHREGX.NOAUTH, 
				StaticParams.PATHREGX.CSS,StaticParams.PATHREGX.JS,StaticParams.PATHREGX.IMG).permitAll()//无需访问权限
		
		.antMatchers(StaticParams.PATHREGX.AUTHADMIN).hasAuthority(StaticParams.USERROLE.ROLE_ADMIN)//admin角色访问权限
		
		.antMatchers(StaticParams.PATHREGX.AUTHUSER).hasAuthority(StaticParams.USERROLE.ROLE_USER)//user角色访问权限
		
		.anyRequest()//all others request authentication
		.authenticated()
		.and()
		.formLogin().loginPage("/login").permitAll()
		.and()
		.logout().logoutUrl("/logout").deleteCookies("remember-me").logoutSuccessUrl("/nopass").permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	}

}
