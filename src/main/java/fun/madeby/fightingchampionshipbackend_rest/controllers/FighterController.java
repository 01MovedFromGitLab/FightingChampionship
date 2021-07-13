package fun.madeby.fightingchampionshipbackend_rest.controllers;

import fun.madeby.fightingchampionshipbackend_rest.models.Fight;
import fun.madeby.fightingchampionshipbackend_rest.models.FightRecord;
import fun.madeby.fightingchampionshipbackend_rest.models.Fighter;
import fun.madeby.fightingchampionshipbackend_rest.services.FighterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FighterController {
private final FighterService fighterService;


@PostMapping("api/fighter/new")
public void addFighter(@RequestBody Fighter fighter) {
	fighterService.register(fighter);
}

@PutMapping("api/fighter/{id}")
public ResponseEntity<Fighter> updateFighter(@PathVariable Long id,
                                             @Valid @RequestBody Fighter fighterDetails) {
	Fighter fighter = fighterService.retrieveById(id);


	fighter.setFirstName(fighterDetails.getFirstName());
	fighter.setLastName(fighterDetails.getLastName());
	fighter.setNickName(fighterDetails.getNickName());
	fighter.setDob(fighterDetails.getDob());
	fighter.setBirthPlace(fighterDetails.getBirthPlace());
	fighter.setCurrentGym(fighterDetails.getCurrentGym());
	fighter.setReach(fighterDetails.getReach());
	fighter.setWeight(fighterDetails.getWeight());
	fighter.setWeightClass(fighterDetails.getWeightClass());
	fighter.setHeight(fighterDetails.getHeight());
	fighter.setStance(fighterDetails.getStance());

	final Fighter updatedFighter = fighterService.register(fighter);
	return ResponseEntity.ok(updatedFighter);
}


@GetMapping(value = "api/fighter/{id}")
public Fighter fighterById(@PathVariable Long id) {
	return fighterService.retrieveById(id);
}

/*@GetMapping(value="api/fighter/won/{id}")
@ResponseBody
public List<Fight> fightsWonById(@PathVariable Long id) {
	return  fighterService.retrieveWonFights(id);
}*/

@GetMapping(value="api/fighter/record/{id}")
public FightRecord retrieveFightResults(@PathVariable Long id){
	// Yes I know @Query and count would be quicker and more elegant but busy learning this..
	FightRecord fightRecord = new FightRecord();
	List<Fight> wonFights = fighterService.retrieveWonFights(id);
	List<Fight> drawnFights = fighterService.retrieveDrawnFights(id);
	int totalLost = fighterService.retrieveLostFightCount(id);

	fightRecord.setFighterId(id);
	fightRecord.setWins(wonFights.size());
	fightRecord.setDraws(drawnFights.size());
	fightRecord.setLosses(totalLost);

	return fightRecord;
}


@GetMapping(value = "api/fighters")
public List<Fighter> allFighters() {
	return fighterService.retrieveAll();
}

}
