package fun.madeby.fightingchampionshipbackend_rest.services;

import fun.madeby.fightingchampionshipbackend_rest.models.Fighter;
import fun.madeby.fightingchampionshipbackend_rest.repositories.FighterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FighterServiceImpl implements FighterService{
	private final FighterRepository FIGHTER_REPO;

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
}
