package fun.madeby.fightingchampionshipbackend_rest;

import fun.madeby.fightingchampionshipbackend_rest.models.Fighter;
import fun.madeby.fightingchampionshipbackend_rest.models.WeightClass;
import fun.madeby.fightingchampionshipbackend_rest.services.FighterService;
import fun.madeby.fightingchampionshipbackend_rest.services.WeightClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.Month;

@Component
//@Profile("dev") // Look into this and have dev/prod
@RequiredArgsConstructor
public class Bootstrap {
private final FighterService fighterService;
private final WeightClassService weightClassService;

// // to turn off @PostConstruct
@PostConstruct
public void init(){
	// Make Fighter /stances/Muay Thai/Grappling/ Counter Striker / Karate
	Fighter fighter01 = new Fighter();
	fighter01.setFirstName("Herbert");
	fighter01.setLastName("Lindsay");
	fighter01.setNickName("Say what?");
	fighter01.setDob(LocalDate.of(1995, Month.APRIL, 17));
	fighter01.setBirthPlace("Clacton-On-Sea");
	fighter01.setCurrentGym("Bert's Dirt Dive");
	fighter01.setStance("Karate");
	fighter01.setWeight(80.6);
	fighter01.setHeight(140.7);
	fighter01.setReach(85.5);

	fighterService.register(fighter01);

/*	Fighter fighter01 = new Fighter();
	fighter01.setFirstName();
	fighter01.setLastName();
	fighter01.setNickName();
	fighter01.setDob(LocalDate.of(1995, Month.APRIL, 17));
	fighter01.setBirthPlace();
	fighter01.setCurrentGym();
	fighter01.setStance();
	fighter01.setWeight();
	fighter01.setHeight();
	fighter01.setReach();*/

	// Make Weight Classs
	WeightClass strawWeight = new WeightClass("Strawweight", "SW");
	WeightClass flyWeight = new WeightClass("Flyweight", "FW");
	WeightClass bantamWeight = new WeightClass("Bantamweight", "BW");
	WeightClass featherWeight = new WeightClass("Featherweight", "FeW");
	WeightClass lightWeight = new WeightClass("Lightweight", "LW");
	WeightClass welterWeight = new WeightClass("Welterweight", "WW");
	WeightClass middleWeight = new WeightClass("Middleweight", "MW");
	WeightClass lightHeavyWeight = new WeightClass("Light Heavyweight", "LHW");
	// Save Weight Classes
	weightClassService.register(strawWeight);
	weightClassService.register(flyWeight);
	weightClassService.register(bantamWeight);
	weightClassService.register(featherWeight);
	weightClassService.register(lightWeight);
	weightClassService.register(welterWeight);
	weightClassService.register(middleWeight);
	weightClassService.register(lightHeavyWeight);




}


}
