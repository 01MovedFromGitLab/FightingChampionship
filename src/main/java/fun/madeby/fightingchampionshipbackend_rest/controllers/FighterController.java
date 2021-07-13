package fun.madeby.fightingchampionshipbackend_rest.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import fun.madeby.fightingchampionshipbackend_rest.models.Fight;
import fun.madeby.fightingchampionshipbackend_rest.models.Fighter;
import fun.madeby.fightingchampionshipbackend_rest.services.FighterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FighterController {
private final FighterService fighterService;

//@GetMapping(value="api/fighter/{id}", produces = "applicatiion/json; charset=UTF-8")

@GetMapping(value = "api/fighter/{id}")
@ResponseBody
public Fighter fighterById(@PathVariable Long id) {
	return fighterService.retrieveById(id);
}

/*@GetMapping(value="api/fighter/won/{id}")
@ResponseBody
public List<Fight> fightsWonById(@PathVariable Long id) {
	return  fighterService.retrieveWonFights(id);
}*/

@GetMapping(value="api/fighter/won/{id}")
@ResponseBody
public ResponseEntity<String> retrieveWonFights(@PathVariable Long id){
	List<Fight> wonFights = fighterService.retrieveWonFights(id);
	int totalWon = wonFights.size();

	return ResponseEntity.status(HttpStatus.OK)
	.body("Total fights won = " + totalWon);
}


@GetMapping(value = "api/fighters")
@ResponseBody
public List<Fighter> allFighters() {
	return fighterService.retrieveAll();
}

}
