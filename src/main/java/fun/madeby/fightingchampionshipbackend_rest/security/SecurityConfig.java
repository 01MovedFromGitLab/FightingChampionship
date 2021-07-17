package fun.madeby.fightingchampionshipbackend_rest.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
private final PasswordEncoder passwordEncoder;
private final UserDetailsService userDetailsService;

@Override
public void configure(HttpSecurity httpSecurity) throws Exception {

	httpSecurity
		.authorizeRequests()
		.antMatchers("/results").hasRole("ADMIN");
			                        //.hasRole("ADMIN")
	//.antMatchers(HttpMethod.GET, "/fighter").permitAll();
	//.antMatchers(HttpMethod.POST, "/fighters/new").permitAll()
	//.and()
	//.formLogin()
	//.loginPage("/login");


}

@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder);
}

}
