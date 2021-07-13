package fun.madeby.fightingchampionshipbackend_rest.services;

import fun.madeby.fightingchampionshipbackend_rest.models.Fight;
import java.util.List;

public interface FightService {
	void register(Fight fight);
	Fight retrieveById(Long id);
	List<Fight> retrieveAll();
}
