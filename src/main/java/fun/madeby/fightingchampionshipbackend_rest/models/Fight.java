package fun.madeby.fightingchampionshipbackend_rest.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Fight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name ="IsFinished", columnDefinition = "BOOLEAN DEFAULT FALSE")
	private Boolean isFinished;
	@Column(name="FinishedInRound", columnDefinition = "BIGINT NULL") // Null before event
	private Long finishedInRound;
	@Column(name="FinishTime", columnDefinition = "DATETIME NULL")
	@DateTimeFormat(pattern = "yyyy-MM-dd-HH:mm")
	private LocalDateTime finishTime;
	@Column(name="FinishMethod", columnDefinition = "VARCHAR(50) NULL")
	private String finishMethod;

	@OneToOne
	@JoinColumn(name="RedFighterId", columnDefinition = "BIGINT NOT NULL")
	private Fighter redFighter;

	@OneToOne
	@JoinColumn(name="Winner", columnDefinition = "BIGINT NULL")
	private Fighter winner;

	@OneToOne
	@JoinColumn(name="BlueFighterId", columnDefinition = "BIGINT NOT NULL")
	private Fighter blueFighter;

	@ManyToOne // 01-Every fight belongs to a weight class
	@JoinColumn(name="WeightClass")
	private WeightClass weightClass;

	@ManyToOne // 02-Every fight belongs to an event
	@JoinColumn(name="EventId")
	private Event event;

	// 01
	public void addFightToWeightClass(Fight fight) {
	if(!weightClass.getFights().contains(this))
		weightClass.getFights().add(this);
	}
	// 02
	public void addFightToEvent(Fight fight) {
		if(!event.getFightCard().contains(this))
			event.getFightCard().add(this);
	}

public Fight() {
}

public Fight(Boolean isFinished, Long finishedInRound, LocalDateTime finishTime,
             String finishMethod, Fighter redFighter, Fighter winner, Fighter blueFighter,
             WeightClass weightClass, Event event) {
	this.isFinished = isFinished;
	this.finishedInRound = finishedInRound;
	this.finishTime = finishTime;
	this.finishMethod = finishMethod;
	this.redFighter = redFighter;
	this.winner = winner;
	this.blueFighter = blueFighter;
	this.weightClass = weightClass;
	this.event = event;
	// Auto add 01
	addFightToWeightClass(this);
	// Auto add 02
	addFightToEvent(this);
}
}
