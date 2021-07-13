package fun.madeby.fightingchampionshipbackend_rest.controllers;

import fun.madeby.fightingchampionshipbackend_rest.models.Fight;
import fun.madeby.fightingchampionshipbackend_rest.models.FightRecord;
import fun.madeby.fightingchampionshipbackend_rest.models.Fighter;
import fun.madeby.fightingchampionshipbackend_rest.services.FighterService;
import lombok.RequiredArgsConstructor;
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

@GetMapping(value="api/fighter/record/{id}")
@ResponseBody
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
@ResponseBody
public List<Fighter> allFighters() {
	return fighterService.retrieveAll();
}

}
