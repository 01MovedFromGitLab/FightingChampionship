package fun.madeby.fightingchampionshipbackend_rest.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class WeightClass {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(name = "Name", columnDefinition = "VARCHAR(100) NOT NULL")
private String name;
@Column(name = "Abbreviation", columnDefinition = "VARCHAR(10) NOT NULL")
private String abbreviation;
@OneToMany(mappedBy="weightClass", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
private Set<Fighter> fighters = new HashSet<>();
@OneToMany(mappedBy="weightClass", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
private Set<Fight> fights = new HashSet<>();


public WeightClass() {
}

public WeightClass(String name, String abbreviation, Set<Fighter> fighters) {
	this.name = name;
	this.abbreviation = abbreviation;
	this.fighters = fighters;
}

public WeightClass(String name, String abbreviation) {
	this.name = name;
	this.abbreviation = abbreviation;
	this.fighters = null;
}
}
