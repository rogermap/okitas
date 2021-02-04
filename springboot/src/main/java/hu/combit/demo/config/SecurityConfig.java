/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.combit.demo.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private DataSource dataSource;
    
    	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
            /*
		auth.inMemoryAuthentication().withUser("javainuse")
				.password("{noop}javainuse").roles("USER");
*/
            auth.jdbcAuthentication().passwordEncoder( NoOpPasswordEncoder.getInstance())
            .dataSource(dataSource)
            .usersByUsernameQuery("select nev username, nev password, 1 from DEMO_SZULO where nev=?")
            .authoritiesByUsernameQuery("select ? as username, 'USER' role from dual")
        ;
	}
    @Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .formLogin().permitAll()
            .and()
            .logout().permitAll();  

	}

}
