package fun.madeby.fightingchampionshipbackend_rest.services;

import fun.madeby.fightingchampionshipbackend_rest.models.Fight;
import fun.madeby.fightingchampionshipbackend_rest.models.Fighter;
import fun.madeby.fightingchampionshipbackend_rest.repositories.FightRepository;
import fun.madeby.fightingchampionshipbackend_rest.repositories.FighterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FighterServiceImpl implements FighterService{
	private final FighterRepository FIGHTER_REPO;
	private final FightRepository FIGHT_REPO;

@Override
public void register(Fighter fighter) {
	FIGHTER_REPO.save(fighter);
}

@Override
public Fighter retrieveById(Long id) {
	return FIGHTER_REPO.findById(id).orElseThrow(RuntimeException::new);
}

@Override
public List<Fighter> retrieveAll() {
	return FIGHTER_REPO.findAll();

}

// Jpa keyword query that returns complex fight object list
// where passed id was the winner.
@Override
public List<Fight> retrieveWonFights(Long id) {
	Fighter fighter = retrieveById(id);
	return FIGHT_REPO.findFightsByIsFinishedNotNullAndWinnerIs(fighter);
}


/*public ResponseEntity<String> retrieveWonFights(Long id){
	Fighter fighter = retrieveById(id);
	List<Fight> wonFights = FIGHT_REPO.findFightsByIsFinishedNotNullAndWinnerIs(fighter);
	int totalWon = wonFights.size();

	return ResponseEntity.status(HttpStatus.OK)
	.body("Total fights won = " + totalWon);
}*/

}
