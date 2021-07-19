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

//private final PasswordEncoder passwordEncoder;
private final UserDetailsService userDetailsService;

@Override
public void configure(HttpSecurity httpSecurity) throws Exception {

	httpSecurity.authorizeRequests()
		.anyRequest().authenticated()
		.and()
		.httpBasic();
		// disable cross-site request forgery // This works
		//.csrf().disable()
		// This seems to work as without it ok get but with will not get BUT console calls it a cors issue first then an unknown error.
		//.authorizeRequests().anyRequest().authenticated()
		// If this was working in any way a normal visit to 4200 would not allow access to /results
		//.antMatchers("/results").hasRole("ADMIN");

	// So, at this point and for the last number of days this does not seem to be working, though this is
	// the first time I am properly investigating, the instructions are wrong, you do not add spring
	// security and suddenly get a log in page, spring is on 8080 and this is running on 4200.
		//.antMatchers("/results").hasRole("ADMIN")
		//.and().csrf().disable();
			                        //.hasRole("ADMIN")
	//.antMatchers(HttpMethod.GET, "/fighter").permitAll();
	//.antMatchers(HttpMethod.POST, "/fighters/new").permitAll()
	//.and()
	//.formLogin()
	//.loginPage("/login");


}

/*@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder);
}*/

}
