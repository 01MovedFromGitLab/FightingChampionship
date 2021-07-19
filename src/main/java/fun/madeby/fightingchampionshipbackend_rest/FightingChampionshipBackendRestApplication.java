package fun.madeby.fightingchampionshipbackend_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class FightingChampionshipBackendRestApplication {

public static void main(String[] args) {
	SpringApplication.run(FightingChampionshipBackendRestApplication.class, args);
}

//@Bean
/*public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
}*/


}
