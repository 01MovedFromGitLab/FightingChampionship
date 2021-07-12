package fun.madeby.fightingchampionshipbackend_rest.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

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
	@Column(name="Date", columnDefinition = "")
	@DateTimeFormat(pattern = "yyyy-MM-dd-HH:mm")
	private LocalDateTime startDateTime;
	@ManyToOne
	@JoinColumn(name="VenueId")
	private Venue venue;



}
