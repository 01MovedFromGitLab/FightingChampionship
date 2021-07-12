package fun.madeby.fightingchampionshipbackend_rest.models;

import lombok.Getter;
import lombok.Setter;

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
@JoinColumn(name="WeightClassId")
private WeightClass weightClass;

public void addToWeightClass(Fighter fighter) {
	if(!weightClass.getFighters().contains(this))
		weightClass.getFighters().add(this);
}





}
