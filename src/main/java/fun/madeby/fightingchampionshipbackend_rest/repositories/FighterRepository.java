package fun.madeby.fightingchampionshipbackend_rest.repositories;

import fun.madeby.fightingchampionshipbackend_rest.models.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FighterRepository extends JpaRepository<Fighter, Long> {
}
