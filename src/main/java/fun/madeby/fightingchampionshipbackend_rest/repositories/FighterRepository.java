package fun.madeby.fightingchampionshipbackend_rest.repositories;

import fun.madeby.fightingchampionshipbackend_rest.models.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

public interface FighterRepository extends JpaRepository<Fighter, Long> {
	@Query("SELECT f FROM Fighter f WHERE f.dob < ?1")
	List<Fighter> bornBefore(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date);
}
