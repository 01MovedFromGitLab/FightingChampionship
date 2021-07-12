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

	// Make Weight Classes
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

	// Make Fighter01 /--> stances/Muay Thai/Grappling/ Counter Striker / Karate
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
	fighter01.setWeightClass(strawWeight);
	fighterService.register(fighter01);

	Fighter fighter02 = new Fighter();
	fighter02.setFirstName("Julie");
	fighter02.setLastName("Mc Aram");
	fighter02.setNickName("Wam-Bam-McSpam");
	fighter02.setDob(LocalDate.of(1993, Month.MARCH, 26));
	fighter02.setBirthPlace("Glasgow");
	fighter02.setCurrentGym("The Septic Tank");
	fighter02.setStance("Muay Thai");
	fighter02.setWeight(78.9);
	fighter02.setHeight(135.4);
	fighter02.setReach(87.3);
	fighter02.setWeightClass(strawWeight);
	fighterService.register(fighter02);

	Fighter fighter03 = new Fighter();
	fighter03.setFirstName("Digbert");
	fighter03.setLastName("Dimbleweed");
	fighter03.setNickName("Hurts lockers");
	fighter03.setDob(LocalDate.of(1996, Month.NOVEMBER, 7));
	fighter03.setBirthPlace("Chiswick");
	fighter03.setCurrentGym("Lobo-Labas");
	fighter03.setStance("Counter-Striker");
	fighter03.setWeight(82.3);
	fighter03.setHeight(146.0);
	fighter03.setReach(90.0);
	fighter03.setWeightClass(middleWeight);
	fighterService.register(fighter03);
}


}
