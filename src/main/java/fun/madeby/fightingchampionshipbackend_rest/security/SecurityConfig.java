package fun.madeby.fightingchampionshipbackend_rest.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity
			.authorizeRequests()
			.antMatchers("/results").authenticated()
				                        //hasRole("ADMIN") //This role/role table does not exist yet.
			.antMatchers(HttpMethod.GET, "/fighter").permitAll()
			.antMatchers(HttpMethod.POST, "/fighters/new").permitAll()
			.and()
			.formLogin()
			.loginPage("/login");


	}
/*@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userDetailsService)
		.passwordEncoder(encoder);
}*/

}
