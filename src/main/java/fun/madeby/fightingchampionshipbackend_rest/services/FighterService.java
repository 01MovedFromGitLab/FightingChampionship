package fun.madeby.fightingchampionshipbackend_rest.services;

import fun.madeby.fightingchampionshipbackend_rest.models.Fighter;

import java.util.List;

public interface FighterService {
void register(Fighter fighter);
Fighter retrieveById(Long id);
List<Fighter> retrieveAll();
}