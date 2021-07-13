package fun.madeby.fightingchampionshipbackend_rest.repositories;

import fun.madeby.fightingchampionshipbackend_rest.models.Fight;
import fun.madeby.fightingchampionshipbackend_rest.models.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FightRepository extends JpaRepository<Fight, Long> {
	List<Fight> findFightsByIsFinishedNotNullAndWinnerIs(Fighter fighter);

}
