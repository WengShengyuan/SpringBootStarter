package org.wsy.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.wsy.core.generic.staticparams.StaticParams;
import org.wsy.spring.security.authenticationprovider.MyAuthenticationProvider;

@Configurable
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyAuthenticationProvider provider;
	
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
		.logout().permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		//将验证过程交给自定义验证工具
		auth.authenticationProvider(provider);
	}

}
