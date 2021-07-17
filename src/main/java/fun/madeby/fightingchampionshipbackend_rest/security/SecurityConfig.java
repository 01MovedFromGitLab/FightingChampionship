package fun.madeby.fightingchampionshipbackend_rest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity
			.authorizeRequests()
			.antMatchers("/results").hasRole("ADMIN") //This role/role table does not exist yet.
			.antMatchers(HttpMethod.GET, "/", "/**").permitAll()
			.and()
			.formLogin()
			.loginPage("/login");


	}
}
