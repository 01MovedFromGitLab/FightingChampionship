package fun.madeby.fightingchampionshipbackend_rest.services;

import fun.madeby.fightingchampionshipbackend_rest.models.Fight;
import fun.madeby.fightingchampionshipbackend_rest.models.Fighter;

import java.util.List;

public interface FighterService {
Fighter register(Fighter fighter);
void remove(Long id);
Fighter retrieveById(Long id);
List<Fighter> retrieveAll();
List<Fight> retrieveWonFights(Long id);
List<Fight> retrieveDrawnFights(Long id);
Integer retrieveLostFightCount(Long id);

}
