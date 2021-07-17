package fun.madeby.fightingchampionshipbackend_rest.repositories;

import fun.madeby.fightingchampionshipbackend_rest.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
Page<User> findAll(Pageable pageable);
User findByuserName(String username);

}
