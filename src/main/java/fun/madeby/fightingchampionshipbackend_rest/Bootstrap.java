package fun.madeby.fightingchampionshipbackend_rest;

import fun.madeby.fightingchampionshipbackend_rest.models.*;
import fun.madeby.fightingchampionshipbackend_rest.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

@Component
//@Profile("dev") // Look into this and have dev/prod
@RequiredArgsConstructor
public class Bootstrap {
private final FighterService fighterService;
private final WeightClassService weightClassService;
private final VenueService venueService;
private final EventService eventService;
private final FightService fightService;

// // to turn off @PostConstruct
//@PostConstruct
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

	// Make Fighters /--> stances/Muay Thai/Grappling/ Counter Striker / Karate
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

	Fighter fighter04 = new Fighter();
	fighter04.setFirstName("Dolores");
	fighter04.setLastName("Stoob");
	fighter04.setNickName("Stoobie-Do");
	fighter04.setDob(LocalDate.of(1995, Month.DECEMBER, 13));
	fighter04.setBirthPlace("Ashfield");
	fighter04.setCurrentGym("Dirigible's Dry Test");
	fighter04.setStance("Grappling");
	fighter04.setWeight(85.3);
	fighter04.setHeight(150.0);
	fighter04.setReach(92.0);
	fighter04.setWeightClass(lightWeight);
	fighterService.register(fighter04);

	// Make Venues
	Venue venue01 = new Venue("UFC Apex", "6650 El Camino Road, Las Vegas, Nevada, 89118");
	Venue venue02 = new Venue("Chartway Arena", "4320 Hampton Blvd, Norfolk, Virginia, 23529");
	venueService.register(venue01);
	venueService.register(venue02);

	// Make Events
	Event event01 =  new Event();
	Event event02 =  new Event();

	event01.setName("The Definitive Thump");
	event01.setStartDateTime(LocalDateTime.of(2021, Month.JUNE, 30, 20, 0));
	event01.setVenue(venue02);

	event02.setName("Grudge-Sugar-Pain-Magic");
	event02.setStartDateTime(LocalDateTime.of(2021, Month.OCTOBER, 30, 20, 0));
	event02.setVenue(venue01);

	eventService.register(event01);
	eventService.register(event02);

	// Create Past (Event01) Fights
	Fight fight01 = new Fight();
	fight01.setEvent(event01);
	fight01.setWeightClass(bantamWeight);
	fight01.setBlueFighter(fighter01);
	fight01.setRedFighter(fighter02);
	fight01.setIsFinished(true);
	fight01.setFinishedInRound(4L);
	fight01.setFinishMethod("KO");
	fight01.setFinishTime(LocalDateTime.of(2021, Month.JUNE, 30, 20, 45));
	fight01.setWinner(fighter01);
	fightService.register(fight01);

	Fight fight02 = new Fight();
	fight02.setEvent(event01);
	fight02.setWeightClass(bantamWeight);
	fight02.setBlueFighter(fighter04);
	fight02.setRedFighter(fighter03);
	fight02.setIsFinished(true);
	fight02.setFinishedInRound(8L);
	fight02.setFinishMethod("TKO");
	fight02.setFinishTime(LocalDateTime.of(2021, Month.JUNE, 30, 21, 55));
	fight02.setWinner(fighter03);
	fightService.register(fight02);

	// Create Future (Event 02) Fights

	Fight fight03 = new Fight();
	fight03.setEvent(event02);
	fight03.setWeightClass(welterWeight);
	fight03.setBlueFighter(fighter01);
	fight03.setRedFighter(fighter04);
	//fight03.setIsFinished(true);
	//fight03.setFinishedInRound(10L);
	//fight03.setFinishMethod("Points");
	//fight03.setFinishTime(LocalDateTime.of(2021, Month.OCTOBER, 30, 20, 55));
	//fight03.setWinner(fighter01);
	fightService.register(fight03);

	Fight fight04 = new Fight();
	fight04.setEvent(event02);
	fight04.setWeightClass(welterWeight);
	fight04.setBlueFighter(fighter03);
	fight04.setRedFighter(fighter02);
	//fight04.setIsFinished(true);
	//fight04.setFinishedInRound(3L);
	//fight04.setFinishMethod("KO");
	//fight04.setFinishTime(LocalDateTime.of(2021, Month.JUNE, 30, 22, 30));
	//fight04.setWinner(fighter03);
	fightService.register(fight04);

}


}
