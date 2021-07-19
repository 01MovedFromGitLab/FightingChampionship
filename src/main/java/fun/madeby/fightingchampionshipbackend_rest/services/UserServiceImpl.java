package fun.madeby.fightingchampionshipbackend_rest.services;

import fun.madeby.fightingchampionshipbackend_rest.models.User;
import fun.madeby.fightingchampionshipbackend_rest.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;


// NOTE: in e.g not using Lombok so uses @Transactional here..
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository USER_REPO;
	//private final PasswordEncoder pwdEncoder;


	// NOTE: ..and @Autowired here
@Override
public Page<User> retrieveAll(Pageable pageable) {
	return USER_REPO.findAll(pageable);
}

/*@Override
public void addMultipleUsers(Iterable<User> userIterable) {
	for(User u: userIterable){
		String encodedPassword = pwdEncoder.encode(u.getPassword());
		u.setPassword(encodedPassword);
	}
	USER_REPO.saveAll(userIterable);
}*/

/*
@Override
public void addSingleUser(User user) {
	String encodedPassword = pwdEncoder.encode(user.getPassword());
	user.setPassword(encodedPassword);
	//user.addRole(roleRepo.findByName("USER")); // Be sure to add role prior to sending
	USER_REPO.save(user);
}
*/

@Override
public User retrieveByUsername(String username) {

	return USER_REPO.findByuserName(username);

}

}
