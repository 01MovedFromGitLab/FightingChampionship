package fun.madeby.fightingchampionshipbackend_rest.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Venue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Column(name="Name", columnDefinition = "VARCHAR(150) NOT NULL")
	private String name;
	@NotBlank
	@Column(name="Name", columnDefinition = "VARCHAR(500) NOT NULL")
	private String address;
	@OneToMany(mappedBy = "venue", cascade = {CascadeType.PERSIST,
		CascadeType.MERGE, CascadeType.DETACH})
	private Set<Event> events = new HashSet<>();

public Venue() {
}

public Venue(String name, String address, Set<Event> events) {
	this.name = name;
	this.address = address;
	this.events = events;
}

public Venue(String name, String address) {
	this.name = name;
	this.address = address;
	this.events = null;
}
}
