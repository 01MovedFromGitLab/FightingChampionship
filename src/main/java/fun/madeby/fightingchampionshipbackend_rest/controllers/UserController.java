package fun.madeby.fightingchampionshipbackend_rest.controllers;


import fun.madeby.fightingchampionshipbackend_rest.models.User;
import fun.madeby.fightingchampionshipbackend_rest.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {

	// This would have to be @Autowired without Lombok's @RequiredArgsConstructor
	private final UserService userService;

	@GetMapping
	public Page<User> findAll(Pageable pageable) {
		return userService.retrieveAll(pageable);

	}




}
