package fun.madeby.fightingchampionshipbackend_rest.repositories;

import fun.madeby.fightingchampionshipbackend_rest.models.Fight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FightRepository extends JpaRepository<Fight, Long> {
}
