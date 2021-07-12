package fun.madeby.fightingchampionshipbackend_rest.services;

import fun.madeby.fightingchampionshipbackend_rest.models.WeightClass;

import java.util.List;

public interface WeightClassService {
	void register(WeightClass weightClass);
	WeightClass retrieveById(Long id);
	List<WeightClass> retrieveAll();
}
