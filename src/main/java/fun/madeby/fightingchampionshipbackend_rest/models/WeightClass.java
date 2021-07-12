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
private String name;
private String abbreviation;
@OneToMany(mappedBy="weightClass", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
private Set<Fighter> fighters = new HashSet<>();


//@OneToMany(mappedBy="weightClass", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
//private Set<Fight> fights = new HashSet<>();


}

/*
* Strawweight / SW
Flyweight /FW
Bantamweight/ BW
Featherweight/ FeW
Lightweight /LW
Welterweight /WW
Middleweight /MW
Light Heavyweight LHW
* */