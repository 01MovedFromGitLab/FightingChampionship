package fun.madeby.fightingchampionshipbackend_rest.services;

import fun.madeby.fightingchampionshipbackend_rest.models.Fight;
import fun.madeby.fightingchampionshipbackend_rest.models.Fighter;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FighterService {
void register(Fighter fighter);
Fighter retrieveById(Long id);
List<Fighter> retrieveAll();
List<Fight> retrieveWonFights(Long id);
List<Fight> retrieveDrawnFights(Long id);
Integer retrieveLostFightCount(Long id);
}
