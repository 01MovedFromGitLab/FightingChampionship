package fun.madeby.fightingchampionshipbackend_rest.services;

import fun.madeby.fightingchampionshipbackend_rest.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

	Page<User> retrieveAll(Pageable pageable);
	void addMultipleUsers(Iterable<User> userIterable);
	void addSingleUser(User user);
	User retrieveByUsername(String username);
}
