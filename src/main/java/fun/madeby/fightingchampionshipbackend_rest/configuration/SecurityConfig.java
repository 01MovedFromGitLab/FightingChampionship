package fun.madeby.fightingchampionshipbackend_rest.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	public void configure(HttpSecurity httpSecurity) throws Exception {

		// This is if you have H2 in memory db:
		/*httpSecurity.authorizeRequests().antMatchers("/h2/**")
			.permitAll().antMatchers("/api/users/**")
			.hasRole("ADMIN").and().httpBasic()
			.and().httpBasic().and().csrf().disable();

		httpSecurity.headers().frameOptions().disable();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
	}

		 */
	}
}
