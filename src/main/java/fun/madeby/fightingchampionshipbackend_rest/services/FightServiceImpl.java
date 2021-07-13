package fun.madeby.fightingchampionshipbackend_rest.services;

import fun.madeby.fightingchampionshipbackend_rest.models.Fight;
import fun.madeby.fightingchampionshipbackend_rest.repositories.FightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FightServiceImpl implements FightService{
	private final FightRepository FIGHT_REPO;

@Override
public void register(Fight fight) {
	FIGHT_REPO.save(fight);

}

@Override
public Fight retrieveById(Long id) {
	return FIGHT_REPO.findById(id).orElseThrow(RuntimeException::new);
}

@Override
public List<Fight> retrieveAll() {
	return FIGHT_REPO.findAll();
}
}
