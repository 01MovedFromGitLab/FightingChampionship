package fun.madeby.fightingchampionshipbackend_rest.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Fighter {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(name = "FirstName", columnDefinition = "VARCHAR(100) NOT NULL")
private String firstName;
@Column(name = "LastName", columnDefinition = "VARCHAR(100) NOT NULL")
private String lastName;
@Column(name = "NickName", columnDefinition = "VARCHAR(100) NOT NULL")
private String nickName;
@Column(name = "DateOfBirth", columnDefinition = "DATE NOT NULL")
@DateTimeFormat(pattern = "yyyy-MM-dd")
private LocalDate dob;
@Column(name = "BirthPlace", columnDefinition = "VARCHAR(100) NOT NULL")
private String birthPlace;
@Column(name = "CurrentGym", columnDefinition = "VARCHAR(100) NOT NULL")
private String currentGym;
@Column(name = "Stance", columnDefinition = "VARCHAR(100) NOT NULL")
private String stance;
@Column(name = "Weight", columnDefinition = "Decimal(10,2)")
private double weight;
@Column(name = "Height", columnDefinition = "Decimal(10,2)")
private double height;
@Column(name = "Reach", columnDefinition = "Decimal(10,2)")
private double reach;

@ManyToOne
@JsonIgnoreProperties({"fighters", "fights"})
@JoinColumn(name="WeightClassId")
private WeightClass weightClass;

public void addFighterToWeightClass(Fighter fighter) {
	if(!weightClass.getFighters().contains(this))
		weightClass.getFighters().add(this);
}

public Fighter() {
}

public Fighter(String firstName, String lastName, String nickName, LocalDate dob,
               String birthPlace, String currentGym, String stance, double weight,
               double height, double reach, WeightClass weightClass) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.nickName = nickName;
	this.dob = dob;
	this.birthPlace = birthPlace;
	this.currentGym = currentGym;
	this.stance = stance;
	this.weight = weight;
	this.height = height;
	this.reach = reach;
	this.weightClass = weightClass;
	// Auto add
	addFighterToWeightClass(this);
}
}
