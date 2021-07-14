package fun.madeby.fightingchampionshipbackend_rest.repositories;

import fun.madeby.fightingchampionshipbackend_rest.models.Fight;
import fun.madeby.fightingchampionshipbackend_rest.models.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FightRepository extends JpaRepository<Fight, Long> {
	// api/V1 to return fight record of fighter.
	List<Fight> findFightsByIsFinishedNotNullAndWinnerIs(Fighter fighter);
	@Query("SELECT f FROM Fight f WHERE f.isFinished = true AND f.winner = NULL AND (f.blueFighter.id = ?1 OR f.redFighter.id = ?1)")
	List<Fight> findFighterDraws(Long id);
	@Query("SELECT COUNT(f) FROM Fight f  WHERE f.isFinished = true AND (f.winner <> NULL AND f.winner.id <> ?1) AND (f.blueFighter.id = ?1 OR f.redFighter.id = ?1)")
	Integer findFighterLosses(Long id);
}
