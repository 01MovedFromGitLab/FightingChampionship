package fun.madeby.fightingchampionshipbackend_rest.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

// Used as JSON return object == not an @Entity
@Getter
@Setter
@RequiredArgsConstructor
public class FightRecord {
	private Long fighterId;
	private Integer wins;
	private Integer losses;
	private Integer draws;
}
