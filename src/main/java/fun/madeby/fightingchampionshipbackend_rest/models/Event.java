package fun.madeby.fightingchampionshipbackend_rest.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Column(name="Name", columnDefinition = "VARCHAR(250) NOT NULL")
	private String name;
	@NotBlank
	@Column(name="Date", columnDefinition = "DATE NOT NULL")
	@DateTimeFormat(pattern = "yyyy-MM-dd-HH:mm")
	private LocalDateTime startDateTime;
	@ManyToOne
	@JoinColumn(name="VenueId")
	private Venue venue;
	@OneToMany(mappedBy="event", cascade = {CascadeType.PERSIST, CascadeType.MERGE,
		CascadeType.DETACH})
	private Set<Fight> fightCard = new HashSet<>();

	public void addEventToVenue(Event event) {
		if(!venue.getEvents().contains(this))
			venue.getEvents().add(this);
	}

public Event() {
}

public Event(String name, LocalDateTime startDateTime, Venue venue, Set<Fight> fightCard) {
	this.name = name;
	this.startDateTime = startDateTime;
	this.venue = venue;
	this.fightCard = fightCard;
	// Auto add
	addEventToVenue(this);
}

public Event(String name, LocalDateTime startDateTime, Venue venue) {
	this.name = name;
	this.startDateTime = startDateTime;
	this.venue = venue;
	this.fightCard = null;
}
}
