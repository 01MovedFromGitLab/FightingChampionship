/*
package fun.madeby.fightingchampionshipbackend_rest.security;

import fun.madeby.fightingchampionshipbackend_rest.models.Role;
import fun.madeby.fightingchampionshipbackend_rest.models.User;
import fun.madeby.fightingchampionshipbackend_rest.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
	private final UserRepository USER_REPO;


@Override
public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
	User user = new User();
	try{
		user = USER_REPO.findByuserName(s);
		} catch (UsernameNotFoundException unfe) {
		System.out.println("IN UserDetailServiceImpl");
		unfe.printStackTrace();
	}
	Set<GrantedAuthority> authoritySet = new HashSet<>();
	for (Role r : user.getRoles())
		authoritySet.add(new SimpleGrantedAuthority("ROLE " + r.getName()));
	return new org.springframework.security.core.userdetails.User(
		user.getUserName(),
		user.getPassword(),
		authoritySet);
}

}
*/
